package no.hvl.dat108.oblig1.oppgave2;

import java.util.Random;

public class Servitoer extends Thread {

    private final Rutsjebane rutsjebane;
    private Random random = new Random();
    String navn;

    public Servitoer(Rutsjebane rutsjebane, String navn) {
        this.rutsjebane = rutsjebane;
        this.setName(navn);
    }


    @Override
    public void run() {

        while(true) {

            try {
                this.sleep(random.nextInt(4000) + 2000);
                rutsjebane.hentBurger();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            rutsjebane.printBane();
            System.out.println();


        }
    }
}



