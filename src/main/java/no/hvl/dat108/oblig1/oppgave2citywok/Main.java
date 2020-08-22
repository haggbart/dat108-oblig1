package no.hvl.dat108.oblig1.oppgave2citywok;

import no.hvl.dat108.oblig1.oppgave2citywok.models.Kokk;

public class Main {

    public static void main(String[] args) {


        for (int i = 0; i < 5; i++) {
            new Thread(new Kokk()).start();
        }

    }
}
