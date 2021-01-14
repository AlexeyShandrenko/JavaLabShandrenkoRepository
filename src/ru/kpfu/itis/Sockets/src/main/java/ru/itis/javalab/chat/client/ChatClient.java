package ru.itis.javalab.chat.client;

import ru.itis.javalab.app.ChatApplication;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ChatClient {

    private Socket socket;
    private ClientThread clientThread;

    private final ChatApplication application;

    public ChatApplication getApplication() {
        return application;
    }

    public ChatClient(ChatApplication application) {
        this.application = application;
    }

    public void sendMessage(String message) throws IOException {
        try {
            clientThread.getOutput().write(message);
            clientThread.getOutput().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() throws IOException {
        String host = application.getUserConfig().getHost();
        int port = application.getUserConfig().getPort();

        socket = new Socket(host, port);

        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));

        clientThread = new ClientThread(input, output, this);

        new Thread(clientThread).start();
    }

}
