package no.hvl.dat108.oblig1.oppgave2citywok.models;

import java.time.LocalTime;
import java.util.ArrayDeque;
import java.util.Queue;

public class Rutsjebane {
    private Queue<Burger> burgere;

    public Rutsjebane() {
        this.burgere = new ArrayDeque<>();
    }

    public synchronized void add(Kokk kokk, Burger burger) {
        burgere.add(burger);
        System.out.printf("[%s] %s(%d) legger på burger. (%d) => %s\n",
                currentTime(), kokk.getNavn(), kokk.getId(), burger.getId(), this);
    }

    private String currentTime() {
        var time = LocalTime.now();
        return String.format("%02d:%02d", time.getMinute(), time.getSecond());

    }

    @Override
    public String toString() {
        var sb = new StringBuilder("[");
        for (Burger burger : burgere) {
            sb.append('(').append(burger.getId()).append("), ");
        }
        sb.append(']');
        return sb.toString();
    }
}
