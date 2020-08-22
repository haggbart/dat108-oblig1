package no.hvl.dat108.oblig1.oppgave1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class MainTest {

    @Test
    void success() {
        fail();
    }

    @Test
    void main() {

        var t = new Thread(() -> {
            Main.main(null);
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                fail();
            }
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            fail();
        }
    }
}