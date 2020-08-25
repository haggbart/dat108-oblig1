package no.hvl.dat108.oblig1.oppgave3citywok.models;

public class Hamburger {
    private static int counter;
    private final int id;

    public Hamburger() {
        counter++;
        id = counter;
    }

    @Override
    public String toString() {
        return String.format("(%s)", id);
    }
}
