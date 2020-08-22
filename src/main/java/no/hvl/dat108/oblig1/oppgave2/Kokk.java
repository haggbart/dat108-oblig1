package no.hvl.dat108.oblig1.oppgave2;

import java.util.Random;

public class Kokk extends Thread {

    private final Rutsjebane rutsjebane;
    private Random random = new Random(); // Hjelpevariabel for å få random tid mellom 2 og 6 sekunder


    public Kokk(Rutsjebane rutsjebane) {
        this.rutsjebane = rutsjebane;
    }

    @Override
    public void run() {

        boolean test = true;

        while(test) {


            Burger burger = lagBurger();
            try {
                this.sleep(random.nextInt(4000) + 2000);
                rutsjebane.leggTil(burger);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            rutsjebane.printBane();
            System.out.println();
            if (rutsjebane.erFull()) {
                System.out.println(Thread.currentThread().getName() + " venter på å avlevere burger");
            }
        }

    }

    private Burger lagBurger() {
        return new Burger();
    }

}
