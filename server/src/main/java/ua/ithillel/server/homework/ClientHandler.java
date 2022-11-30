package ua.ithillel.server.homework;

import lombok.SneakyThrows;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.time.Instant;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ClientHandler {
    private final Socket socket;
    private final DataOutputStream out;
    private final DataInputStream in;
    private final String name;
    private final Instant createdAt;

    private final Consumer<String> broadcast;


    @SneakyThrows
    public ClientHandler(Socket socket, String name, Instant createdAt, Consumer<String> broadcast) {
        this.socket = socket;
        this.name = name;
        this.createdAt = createdAt;
        this.broadcast = broadcast;

        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());
    }

    @SneakyThrows
    public void listen (){
        while(true) {
            var inboundMessage = in.readUTF();
            broadcast.accept(inboundMessage);
        }
    }
    @SneakyThrows
    public void sendMessage(String message) {
        out.writeUTF(message);
    }
}