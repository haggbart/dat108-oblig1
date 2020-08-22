package no.hvl.dat108.oblig1.oppgave2citywok.models;

import java.util.ArrayDeque;
import java.util.Queue;

import static no.hvl.dat108.oblig1.oppgave2citywok.helpers.Utility.currentTime;

public final class Rutsjebane {

    private final static Rutsjebane instance = new Rutsjebane();
    private final static int CAPACITY = 5;
    private boolean mottarOrdre = true;

    private final Queue<Hamburger> hamburgere;

    public Rutsjebane() {
        this.hamburgere = new ArrayDeque<>();
    }

    public static Rutsjebane getInstance() {
        return instance;
    }

    public synchronized void add(Kokk kokk, Hamburger hamburger) {
        if (hamburgere.size() >= CAPACITY) {
            try {
                System.out.printf("[%s] ### %s er klar med en hamburger, men rutsjebanen er full. Venter! ###\n",
                        currentTime(), kokk);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("[%s] %s legger på hamburger(%d) => %s\n",
                currentTime(), kokk, hamburger.getId(), this);
        hamburgere.add(hamburger);
        if (hamburgere.size() == 1)
            notify(); // vekker den første tråden som venter (det legges kun til 1 burger)
    }

    public synchronized void take(Servitoer servitoer) {
        if (hamburgere.isEmpty()) {
            if (!mottarOrdre) return;
            try {
                System.out.printf("[%s] ### %s vil ta en hamburger, men rutsjebanen er tom. Venter! ###\n",
                        currentTime(), servitoer);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Hamburger hamburger = hamburgere.remove();

        System.out.printf("[%s] %s tar av hamburger(%d) <= %s\n",
                currentTime(), servitoer, hamburger.getId(), this);
        if (hamburgere.size() == CAPACITY - 1) notify();
    }



    public synchronized void steng() {
        System.out.printf("[%s] ### Hamburger-sjappen stenger. Tar ikke imot flere bestillinger... ###\n", currentTime());
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
