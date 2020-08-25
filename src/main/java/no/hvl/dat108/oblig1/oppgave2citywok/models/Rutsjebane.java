package no.hvl.dat108.oblig1.oppgave2citywok.models;

import java.util.ArrayDeque;
import java.util.Queue;

import static no.hvl.dat108.oblig1.oppgave2citywok.helpers.Utility.currentTime;


// singleton class
public class Rutsjebane {

    private static class Loc {
        static final String TOM_RUTSJEBANE = "[%s] ### %s vil ta en hamburger, men rutsjebanen er tom. Venter! ###\n";
        static final String FULL_RUTSJEBANE = "[%s] ### %s er klar med en hamburger, men rutsjebanen er full. Venter! ###\n";
        static final String LEGGTIL = "[%s] %s legger på hamburger%s => %s\n";
        static final String FJERN = "[%s] %s tar av hamburger%s <= %s\n";
        static final String STENGER = "[%s] ### Hamburger-sjappen stenger. Tar ikke imot flere bestillinger... ###\n";
    }

    private final static Rutsjebane instance = new Rutsjebane();
    private final static int CAPACITY = 5;
    private boolean mottarOrdre = true;

    private final Queue<Hamburger> hamburgere;

    private Rutsjebane() {
        this.hamburgere = new ArrayDeque<>();
    }

    public static Rutsjebane getInstance() {
        return instance;
    }

    public synchronized void add(Kokk kokk, Hamburger hamburger) {
        while (hamburgere.size() == CAPACITY) {
            System.out.printf(Loc.FULL_RUTSJEBANE, currentTime(), kokk);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf(Loc.LEGGTIL, currentTime(), kokk, hamburger, this);
        hamburgere.add(hamburger);
        if (hamburgere.size() == 1)
            notify(); // vekker den første tråden som venter (det legges kun til 1 burger)
    }

    public synchronized void take(Servitoer servitoer) {
        while (hamburgere.isEmpty()) {
            if (!mottarOrdre) return;
            System.out.printf(Loc.TOM_RUTSJEBANE, currentTime(), servitoer);
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Hamburger hamburger = hamburgere.remove();

        System.out.printf(Loc.FJERN, currentTime(), servitoer, hamburger, this);
        if (hamburgere.size() == CAPACITY - 1) notify();
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

    @Override
    public String toString() {
        var sb = new StringBuilder("[");
        for (Hamburger hamburger : hamburgere) {
            sb.append(hamburger).append(", ");
        }
        if (!hamburgere.isEmpty())
            sb.setLength(sb.length() - 2);
        sb.append(']');
        return sb.toString();
    }
}
