package fr.lernejo.navy_battle;

import java.io.IOException;
import java.net.http.HttpClient;

public class Launcher {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IllegalArgumentException("Please specify a port number");
        }
        else if (args.length == 1) {
            Server server = new Server(Integer.parseInt(args[0]), "localhost");
            server.createServer();
        }
        else if (args.length == 2) {
            Server server = new Server(Integer.parseInt(args[0]), args[1]);
            server.createServer();
        }
    }
}
