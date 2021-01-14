package ru.itis.javalab.chat.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import ru.itis.javalab.app.ChatApplication;
import ru.itis.javalab.chat.model.UserConfig;

import java.io.IOException;

public class ConfigView extends BaseView {

    private AnchorPane anchorPane = null;
    private TextField name;
    private TextField host;
    private TextField port;
    private Button start;
    private VBox vbox;
    private final ChatApplication application = BaseView.getApplication();
    private final EventHandler<ActionEvent> startEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if (event.getSource() == start) {
                UserConfig userConfig = new UserConfig();
                userConfig.setName(name.getText());
                userConfig.setHost(host.getText());
                userConfig.setPort(Integer.parseInt(port.getText()));

                application.setUserConfig(userConfig);

                try {
                    application.startChatClient();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                application.setView(application.getChatView());
            }
        }
    };

    public ConfigView() throws Exception {
    }

    @Override
    public Parent getView() {
        if (anchorPane == null) {
            this.createView();
        }
        return anchorPane;
    }

    private void createView() {
        anchorPane = new AnchorPane();

        vbox = new VBox(10);

        Label nameLabel = new Label("name");
        name = new TextField();

        vbox.getChildren().add(nameLabel);
        vbox.getChildren().add(name);

        Label hostLabel = new Label("host");
        host = new TextField();
        host.setText("127.0.0.1");

        vbox.getChildren().add(hostLabel);
        vbox.getChildren().add(host);

        Label portLabel = new Label("port");
        port = new TextField();
        port.setText("6666");

        vbox.getChildren().add(portLabel);
        vbox.getChildren().add(port);

        start = new Button("Start");
        start.setOnAction(startEvent);
        vbox.getChildren().add(start);

        AnchorPane.setTopAnchor(vbox, 25.0);
        AnchorPane.setLeftAnchor(vbox, 100.0);
        AnchorPane.setRightAnchor(vbox, 100.0);

        anchorPane.getChildren().add(vbox);
    }
}
