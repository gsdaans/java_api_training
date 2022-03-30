package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LauncherTest {
    private static int testPort = 1111;

    @Test
    public void correctPort() {
        Assertions.assertDoesNotThrow( () -> Launcher.main(new String[] { Integer.toString(testPort) }));
    }

    @Test
    public void noArgs() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> Launcher.main(new String[] {}));
        assertEquals("Please specify a port number", exception.getMessage());
    }

}
