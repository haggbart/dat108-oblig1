package no.hvl.dat108.oblig1.oppgave3citywok.models;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static no.hvl.dat108.oblig1.oppgave3citywok.helpers.Utility.currentTime;


// singleton class
public class Rutsjebane {

    private static class Loc {
        static final String LEGGTIL = "[%s] %s legger på hamburger%s => %s\n";
        static final String FJERN = "[%s] %s tar av hamburger%s <= %s\n";
        static final String STENGER = "[%s] ### Hamburger-sjappen stenger. Tar ikke imot flere bestillinger... ###\n";
    }

    private final static Rutsjebane instance = new Rutsjebane();
    private final static int CAPACITY = 5;
    private boolean mottarOrdre = true;

    private final BlockingQueue<Hamburger> hamburgere;

    private Rutsjebane() {
        this.hamburgere = new LinkedBlockingQueue<>(CAPACITY);
    }

    public static Rutsjebane getInstance() {
        return instance;
    }

    public void add(Kokk kokk, Hamburger hamburger) {
        try {
            hamburgere.put(hamburger);
            System.out.printf(Loc.LEGGTIL, currentTime(), kokk, hamburger, hamburgere);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void take(Servitoer servitoer) {
        try {
            Hamburger hamburger = hamburgere.take();
            System.out.printf(Loc.FJERN, currentTime(), servitoer, hamburger, hamburgere);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void steng() {
        System.out.printf(Loc.STENGER, currentTime());
        mottarOrdre = false;
    }

    public boolean mottarOrdre() {
        return mottarOrdre;
    }

    public boolean isEmpty() {
        return hamburgere.isEmpty();
    }
}
