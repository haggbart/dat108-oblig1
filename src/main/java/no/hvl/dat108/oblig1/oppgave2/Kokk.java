package no.hvl.dat108.oblig1.oppgave2;

import java.util.Random;

public class Kokk extends Thread {

    private final Rutsjebane rutsjebane;
    private Random random = new Random();
    private String navn;

    public Kokk(Rutsjebane rutsjebane, String navn) {
        this.setName(navn);
        this.rutsjebane = rutsjebane;
    }

    @Override
    public void run() {



        while(true) {


            Burger burger = lagBurger();
            try {
                this.sleep(random.nextInt(4000) + 2000);
                if (rutsjebane.erFull()) {
                    System.out.println(Thread.currentThread().getName() + " venter på å avlevere burger");
                    wait();
                }
                rutsjebane.leggTil(burger);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            rutsjebane.printBane();
            System.out.println();


        }

    }

    private Burger lagBurger() {
        return new Burger();
    }

}
