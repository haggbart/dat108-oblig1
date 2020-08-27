package no.hvl.dat108.oblig1.oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Servitor extends Thread {
    private final Rutsjebane rutsjebane;
    private Random random = new Random();

    public Servitor(Rutsjebane rutsjebane, String namn) {
        this.rutsjebane = rutsjebane;
        this.setName(namn);
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(random.nextInt(4000) + 2000);
                rutsjebane.hentBurger();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

