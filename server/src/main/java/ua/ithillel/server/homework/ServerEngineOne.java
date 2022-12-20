package ua.ithillel.server.homework;

import lombok.SneakyThrows;

import java.io.*;
import java.net.ServerSocket;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class ServerEngineOne {
    private final ServerSocket serverSocket;
    private static final int SERVER_PORT = 8888;
    private List<Client> connectedClients = new CopyOnWriteArrayList<>();
    private int clientsNumber;

    @SneakyThrows
    public ServerEngineOne() {
        serverSocket = new ServerSocket(SERVER_PORT);
    }

    public void start() {
        while (true) {
            new Thread(multiThreadClient()).start();
        }
    }

    @SneakyThrows
    private Runnable multiThreadClient() {
        clientsNumber++;
        var client = serverSocket.accept();
        var name = "Client-" + clientsNumber;
        LocalDateTime timeOfConnection = LocalDateTime.now();

        Client connectedClient = new Client(name, timeOfConnection, client);
        connectedClients.add(connectedClient);
        DataInputStream in = new DataInputStream(client.getInputStream());
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
        for (Client connection : connectedClients) {
            DataOutputStream messageAboutConect = new DataOutputStream(connection.getSocket().getOutputStream());
            messageAboutConect.writeUTF("[SERVER] " + connectedClient.getName() + " successfully connected!");
        }
        return () -> {
            try {
                String inBoundMessage;
                while (true) {
                    inBoundMessage = in.readUTF();
                    System.out.println(inBoundMessage);
                    if (inBoundMessage.equals("-exit")) {
                        out.writeUTF("Thank you for the session. Bye!");
                        messageToClients(connectedClient);
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    @SneakyThrows
    private void messageToClients(Client connectedClient) {
        for (Client connection : connectedClients) {
            DataOutputStream messageAboutDisconect =
                    new DataOutputStream(connection.getSocket().getOutputStream());
            if (connection.getName().equals(connectedClient.getName())) {
                connectedClients.remove(connection);
            }
            messageAboutDisconect.writeUTF("[SERVER] " + connectedClient.getName()
                    + " was disconnected");
        }
    }

}