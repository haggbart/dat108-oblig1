package no.hvl.dat108.oblig1.oppgave2citywok.models;

public class Burger {
    private static int counter;
    private final int id;

    public Burger() {
        counter++;
        id = counter;
    }

    public int getId() {
        return id;
    }
}
