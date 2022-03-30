package fr.lernejo.navy_battle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ServerTest {
    private Server server = new Server(9999, "localhost");

    @Test
    public void setUp() throws Exception {
        Server server = new Server(9999, "localhost");
        server.createServer();
    }

}
