package no.hvl.dat108.oblig1.oppgave2citywok.models;

import java.util.Random;

public class Kokk implements Runnable {

    private static final Random random = new Random();
    private static final Rutsjebane rutsjebane = new Rutsjebane();

    @Override
    public void run() {
        while (true) {

            synchronized (this) {
                try {
                    wait(random.nextInt(4000) + 2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rutsjebane.add(new Burger());
            }
        }
    }
}
