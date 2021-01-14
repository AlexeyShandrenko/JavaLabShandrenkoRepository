package ru.itis.javalab.chat.view;

import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import ru.itis.javalab.app.ChatApplication;
import java.io.IOException;

public class ChatView extends BaseView {

    private TextArea input;
    private TextArea conversation;
    private AnchorPane anchorPane = null;
    private final ChatApplication application = BaseView.getApplication();

    private final EventHandler<KeyEvent> onKeyEvent = new EventHandler<KeyEvent>() {

        @Override
        public void handle(KeyEvent event) {
            if (event.getCode() == KeyCode.ENTER) {
                String sender = application.getUserConfig().getName();
                String message = input.getText() + "\n";
                try {
                    application.getChatClient().sendMessage(sender + ": " + message + "\n" + " " + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                conversation.appendText("you: " + message);

                input.clear();
                event.consume();
            }
        }
    };

    public ChatView() throws Exception {
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

        conversation = new TextArea();
        conversation.setEditable(false);
        conversation.setWrapText(true);

        AnchorPane.setBottomAnchor(conversation, 10.0);
        AnchorPane.setRightAnchor(conversation, 10.0);
        AnchorPane.setLeftAnchor(conversation, 10.0);

        anchorPane.getChildren().add(conversation);

        input = new TextArea();
        input.setMaxHeight(50);

        AnchorPane.setBottomAnchor(input, 10.0);
        AnchorPane.setRightAnchor(input, 10.0);
        AnchorPane.setLeftAnchor(input, 10.0);

        input.addEventHandler(KeyEvent.KEY_PRESSED, onKeyEvent);
        anchorPane.getChildren().add(input);
    }

    public void appendMessageToConversation(String message) {
        if (message != null) conversation.appendText(message);
    }
}
