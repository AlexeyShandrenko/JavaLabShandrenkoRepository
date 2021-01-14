package ru.itis.javalab.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class ChatServer {

    private static final int PORT = 6666;
    private ServerSocket socket;
    private final ArrayList<ClientThread> clients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        ChatServer chatServer = new ChatServer();
        chatServer.start();
    }

    public void start() throws IOException {
        socket = new ServerSocket(PORT);

        while (true) {
            Socket clientSocket = socket.accept();

            BufferedWriter output = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream(), StandardCharsets.UTF_8));
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream(), StandardCharsets.UTF_8));

            ClientThread clientThread = new ClientThread(input, output, this);
            clients.add(clientThread);

            new Thread(clientThread).start();
        }
    }

    public void sendMessages(String message, ClientThread sender) throws IOException {
        for (ClientThread clientThread : clients) {
            if (clientThread.equals(sender))
                continue;

            clientThread.getOutput().write(message + "\n");
            clientThread.getOutput().flush();
        }
    }

    public void removeClient(ClientThread clientThread) {
        clients.remove(clientThread);
    }

}
