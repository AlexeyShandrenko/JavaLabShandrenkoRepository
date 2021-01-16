import com.google.auto.service.AutoService;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.imageio.IIOException;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@AutoService(Processor.class)
@SupportedAnnotationTypes(value = {"HtmlForm", "HtmlInput"})
public class HtmlProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        // получить типы с аннотаций HtmlForm
        Set<? extends Element> annotatedElements = roundEnv.getElementsAnnotatedWith(HtmlForm.class);
        for (Element element : annotatedElements) {
            // получаем полный путь для генерации html
            String path = HtmlProcessor.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            // User.class -> User.html
            path = path.substring(1) + element.getSimpleName().toString() + ".html";
            Path out = Paths.get(path);
            Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
            configuration.setDefaultEncoding("UTF-8");
            try {
                configuration.setTemplateLoader(new FileTemplateLoader(new File("D:\\Repository\\JavaLab\\JavaLabShandrenkoRepository\\src\\ru\\kpfu\\itis\\Annotations_SOURCE\\src\\main\\resources\\free")));
                List<Map<String, String>> inputs = new ArrayList<>();
                Map<String, String> annotatedInputElements = new HashMap<>();
//                BufferedWriter writer = new BufferedWriter(new FileWriter(out.toFile()));
                HtmlForm annotation_form = element.getAnnotation(HtmlForm.class);
                for (Element value : element.getEnclosedElements()) {
                    HtmlInput annotation_input = element.getAnnotation(HtmlInput.class);
                    if (annotation_input != null) {
                        annotatedInputElements.put("type", annotation_input.type());
                        annotatedInputElements.put("name", annotation_input.name());
                        annotatedInputElements.put("placeholder", annotation_input.placeholder());
                        inputs.add(annotatedInputElements);
                    }
                }

                Map<String, Object> attributes = new HashMap<>();
                attributes.put("action", annotation_form.action());
                attributes.put("method", annotation_form.method());
                attributes.put("inputs", inputs);
                Template template = configuration.getTemplate("form.ftlh");
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(out.toFile().getAbsoluteFile()));
                    template.process(attributes, writer);
                } catch (IOException | TemplateException e) {
                    throw new IllegalStateException(e);
                }

            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }
        return true;
    }
}
