package no.hvl.dat108.oblig1.oppgave2citywok.models;

import java.util.ArrayDeque;
import java.util.Queue;

public class Rutsjebane {
    private Queue<Burger> burgere;

    public Rutsjebane() {
        this.burgere = new ArrayDeque<>();
    }

    public synchronized void add(Burger burger) {
        burgere.add(burger);
        System.out.println(Thread.currentThread().getName() + " made a burger.");
    }
}
