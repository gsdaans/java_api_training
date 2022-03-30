package fr.lernejo.navy_battle;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            throw new IllegalArgumentException("Please specify a port number");
        }
        else {
            Server server = new Server(Integer.parseInt(args[0]), "localhost");
            server.createServer();
        }
    }
}
