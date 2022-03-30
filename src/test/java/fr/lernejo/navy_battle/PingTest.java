package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

class PingTest {

    @Test
    public void PingTest() throws IOException, InterruptedException {
        Server server = new Server(7777, "localhost");
        server.createServer();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:7777/ping"))
            .setHeader("Accept", "application/json")
            .setHeader("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"id\":\"1\", \"url\":\"http://localhost:6666\", \"message\":\"hello\"}"))
            .build();
        HttpResponse res = client.send(request, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(200, res.statusCode());
    }

}
