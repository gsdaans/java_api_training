package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class Server {
    private final int port;
    private final String url;

    public Server(int port, String url) {
        this.port = port;
        this.url = url;
    }
    public void createServer() throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(url, port), 0);
        server.setExecutor(Executors.newFixedThreadPool(1));
        server.createContext("/ping", new Ping());
        server.createContext("/api/game/start", new Post(port));
        server.start();
        System.out.println("Server created with port " + port);
    }
}
