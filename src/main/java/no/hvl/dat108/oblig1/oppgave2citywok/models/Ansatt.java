package no.hvl.dat108.oblig1.oppgave2citywok.models;

import java.util.Random;

import static no.hvl.dat108.oblig1.oppgave2citywok.helpers.Utility.*;

public abstract class Ansatt {

    protected static final Random random = new Random();
    protected static final Rutsjebane rutsjebane = Rutsjebane.getInstance();

    private final int id;
    private final String navn;

    public Ansatt(int id, String navn) {
        this.id = id;
        this.navn = getNextColor() + navn + resetColor();
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", navn, id);
    }
}
