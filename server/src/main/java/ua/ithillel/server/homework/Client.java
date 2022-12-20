package ua.ithillel.server.homework;

import lombok.*;
import java.net.Socket;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Client {
    private String name;
    private LocalDateTime timeOfConnection;
    private Socket socket;
}