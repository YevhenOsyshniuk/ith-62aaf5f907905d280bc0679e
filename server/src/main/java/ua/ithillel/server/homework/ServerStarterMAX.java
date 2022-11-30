package ua.ithillel.server.homework;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ServerStarterMAX {
    public static final int PORT = 8888;
    private static final Logger log = LogManager.getLogger(ServerStarterMAX.class);
    private ServerSocket serverSocket;
    private final List<ClientHandler> clients = new ArrayList<>();

    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private DataInputStream in;
    private DataOutputStream out;


    @SneakyThrows
    public void serverStarterMax() {
        this.serverSocket = new ServerSocket(PORT);
        log.info("Server is about to start {} on port", PORT);
        var name = "Client - " + (clients.size() + 1);
        final String[] inboundMessage = new String[1];
        while (true) {
            var accept = serverSocket.accept();
            in = new DataInputStream(accept.getInputStream());
            out = new DataOutputStream(accept.getOutputStream());

            executorService.submit(() -> {
                var client = new ClientHandler(accept, name, Instant.now(), this::broadcast);
                broadcast(String.format("[SERVER] %s successfully connected.", name));
                clients.add(client);
                try {
                    inboundMessage[0] = in.readUTF();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            });
            if (inboundMessage[0].equals("-exit")) {
                try {
                    out.writeUTF("Thank you for the session. Bey");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                log.info("Server shutdown");
                break;
            }
        }
    }

    public void broadcast(String message) {
        clients.forEach(sh -> sh.sendMessage(message));
    }
}
