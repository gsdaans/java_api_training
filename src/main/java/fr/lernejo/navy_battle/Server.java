package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {
    private final int port;
    public Server(int port) {
        this.port = port;
    }
    public void createServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new Ping());
        server.start();
        System.out.println("Server created with port " + port);
    }
}
