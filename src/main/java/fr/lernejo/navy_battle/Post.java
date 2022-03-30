package fr.lernejo.navy_battle;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.nio.charset.StandardCharsets;

import java.io.IOException;
import java.io.OutputStream;

public class Post implements HttpHandler {
    public final int port;
    public Post(int port){
        this.port = port;
    }

  public void handle(HttpExchange httpExchange) throws IOException {
        if (httpExchange.getRequestMethod().equals("POST")) {
            String body = "{\"id\":\" " + this.port + "\", \"url\":\"http://localhost:" + this.port + "\", \"message\":\"May the code win\"}";
            String messageReceived = new String(httpExchange.getRequestBody().readAllBytes(), StandardCharsets.UTF_8);
            httpExchange.sendResponseHeaders(202, body.getBytes().length);
            try (OutputStream os = httpExchange.getResponseBody()){
                os.write(body.getBytes());}
        } else {
            httpExchange.sendResponseHeaders(404, 0);
        }
    }
}
