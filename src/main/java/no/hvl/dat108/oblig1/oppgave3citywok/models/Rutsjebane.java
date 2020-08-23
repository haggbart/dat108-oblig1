package no.hvl.dat108.oblig1.oppgave3citywok.models;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static no.hvl.dat108.oblig1.oppgave3citywok.helpers.Utility.currentTime;


// singleton class
public class Rutsjebane {

    private static class Loc {
        static final String TOM_RUTSJEBANE = "[%s] ### %s vil ta en hamburger, men rutsjebanen er tom. Venter! ###\n";
        static final String FULL_RUTSJEBANE = "[%s] ### %s er klar med en hamburger, men rutsjebanen er full. Venter! ###\n";
        static final String LEGGTIL = "[%s] %s legger på hamburger(%d) => %s\n";
        static final String FJERN = "[%s] %s tar av hamburger(%d) <= %s\n";
        static final String STENGER = "[%s] ### Hamburger-sjappen stenger. Tar ikke imot flere bestillinger... ###\n";
    }

    private final static Rutsjebane instance = new Rutsjebane();
    private final static int CAPACITY = 5;
    private boolean mottarOrdre = true;

    private final BlockingQueue<Hamburger> hamburgere;

    private Rutsjebane() {
        this.hamburgere = new ArrayBlockingQueue<>(5);
    }

    public static Rutsjebane getInstance() {
        return instance;
    }

    public void add(Kokk kokk, Hamburger hamburger) {
        if (hamburgere.size() >= CAPACITY) {
            System.out.printf(Loc.FULL_RUTSJEBANE, currentTime(), kokk);
        }
        System.out.printf(Loc.LEGGTIL, currentTime(), kokk, hamburger.getId(), this);
        try {
            hamburgere.put(hamburger);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void take(Servitoer servitoer) {
        if (hamburgere.isEmpty()) {
            if (!mottarOrdre) return;
            System.out.printf(Loc.TOM_RUTSJEBANE, currentTime(), servitoer);
        }
        Hamburger hamburger = null;
        try {
            hamburger = hamburgere.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.printf(Loc.FJERN, currentTime(), servitoer, hamburger.getId(), this);
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
            sb.append('(').append(hamburger.getId()).append("), ");
        }
        if (!hamburgere.isEmpty())
            sb.setLength(sb.length() - 2);
        sb.append(']');
        return sb.toString();
    }
}
