package no.hvl.dat108.oblig1.oppgave2citywok.models;


import java.util.Random;

import static no.hvl.dat108.oblig1.oppgave2citywok.helpers.Utility.getNextColor;
import static no.hvl.dat108.oblig1.oppgave2citywok.helpers.Utility.resetColor;


public abstract class Ansatt {

    protected static final Random random = new Random();
    protected static final Rutsjebane rutsjebane = Rutsjebane.getInstance();

    private final int id;
    private final String tittel;

    public Ansatt(int id) {
        this.id = id;
        this.tittel = getNextColor() + (this instanceof Kokk ? "Kokk" : "Servitør") + resetColor();
    }

    @Override
    public String toString() {
        return String.format("%s(%s)", tittel, id);
    }
}