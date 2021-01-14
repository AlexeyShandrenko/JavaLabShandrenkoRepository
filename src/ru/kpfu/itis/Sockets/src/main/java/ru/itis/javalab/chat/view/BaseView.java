package ru.itis.javalab.chat.view;

import javafx.scene.Parent;
import ru.itis.javalab.app.ChatApplication;

public abstract class BaseView {

    private static ChatApplication application;

    public abstract Parent getView();

    public static void setApplication(ChatApplication application) {
        BaseView.application = application;
    }

    public static ChatApplication getApplication() throws Exception {
        if (application != null) {
            return application;
        }
        throw new Exception("No application in BaseView");
    }
}
