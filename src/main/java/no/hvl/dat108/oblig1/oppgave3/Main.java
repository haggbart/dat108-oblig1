package no.hvl.dat108.oblig1.oppgave3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    public static void main(String[] args) {

        BlockingQueue<Burger> bq = new LinkedBlockingQueue<Burger>(5);

        Kokk kokk1 = new Kokk(bq,"Mads");
        Kokk kokk2 = new Kokk(bq,"Preben");
        Kokk kokk3 = new Kokk(bq, "Roger");
        Servitoer s1 = new Servitoer(bq, "Finleif");
        Servitoer s2 = new Servitoer(bq, "Kristin");

        s1.start();
        s2.start();
        kokk1.start();
        kokk2.start();
        kokk3.start();

    }
}
