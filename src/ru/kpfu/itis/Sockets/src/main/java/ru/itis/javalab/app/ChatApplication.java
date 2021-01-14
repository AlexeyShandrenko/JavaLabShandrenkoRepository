package ru.itis.javalab.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ru.itis.javalab.chat.client.ChatClient;
import ru.itis.javalab.chat.model.UserConfig;
import ru.itis.javalab.chat.view.BaseView;
import ru.itis.javalab.chat.view.ChatView;
import ru.itis.javalab.chat.view.ConfigView;

import java.io.IOException;

public class ChatApplication extends Application {

    public Stage primaryStage;

    private BorderPane rootLayout;

    private UserConfig userConfig;

    private ChatClient chatClient;

    private ConfigView configView;

    private ChatView chatView;

    public UserConfig getUserConfig() {
        return userConfig;
    }

    public ChatClient getChatClient() {
        return chatClient;
    }

    public void setUserConfig(UserConfig userConfig) {
        this.userConfig = userConfig;
    }

    public ConfigView getConfigView() {
        return configView;
    }

    public void setConfigView(ConfigView configView) {
        this.configView = configView;
    }

    public ChatView getChatView() {
        return chatView;
    }

    public void setChatView(ChatView chatView) {
        this.chatView = chatView;
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void startChatClient() throws IOException {
        getChatClient().start();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Chat");
        this.primaryStage.setOnCloseRequest(e -> System.exit(0));

        chatClient = new ChatClient(this);

        BaseView.setApplication(this);

        configView = new ConfigView();
        chatView = new ChatView();

        this.initLayout();
    }

    private void initLayout() {
        rootLayout = new BorderPane();

        Scene scene = new Scene(rootLayout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        this.setView(getConfigView());
    }

    public void setView(BaseView view) {
        rootLayout.setCenter(view.getView());
    }

    public void appendMessageToChat(String message) {
        chatView.appendMessageToConversation(message);
    }

}
