package ua.ithillel.client.homework;

import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientEngine {

    private static final Logger log = LogManager.getLogger(ClientEngine.class);
    private static final String SERVER_HOST = "localhost";
    private static final int SERVER_PORT = 8888;
    private final Socket socket;
    private final DataInputStream in;
    private final DataOutputStream out;


    @SneakyThrows
    public ClientEngine() {
        log.info("Client is about to start...");
        socket = new Socket(SERVER_HOST, SERVER_PORT);
        log.info(
                "Client is up and running on: {}:{}",
                socket.getInetAddress().getHostName(),
                socket.getLocalPort()
        );

        log.info("The client successfully connected: {}", socket.getRemoteSocketAddress());

        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());

        new Thread(getListner()).start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            var outboundMessage = scanner.nextLine();
            out.writeUTF(outboundMessage);
            if (outboundMessage.equals("-exit")) {
                log.info("Client disconnected...");
                break;
            }

        }
    }

    private Runnable getListner() {
        return () -> {
            try {
                while (true) {
                    var inboundMessage = in.readUTF();
                    if (inboundMessage.toLowerCase().contains("bey"))
                        break;
                    System.out.println("Server response: " + inboundMessage);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
