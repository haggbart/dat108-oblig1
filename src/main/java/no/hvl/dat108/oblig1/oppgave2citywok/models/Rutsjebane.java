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
        System.out.printf("[%s] %s(%d) legger på burger. (%d) => %s\n",
                currentTime(), kokk.getNavn(), kokk.getId(), burger.getId(), this);
        burgere.add(burger);
        notify(); // vekker den første tråden som venter (det legges kun til 1 burger)
    }

    public synchronized boolean take(Servitoer servitoer) {
        if (burgere.isEmpty()) {
            try {
                System.out.printf("### %s(%d) vil ta en hamburger, men rutsjebanen er tom. Venter! ###\n",
                        servitoer.getNavn(), servitoer.getId());
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Burger burger = burgere.remove();

        System.out.printf("[%s] %s(%d) tar av burger. (%d) <= %s\n",
                currentTime(), servitoer.getNavn(), servitoer.getId(), burger.getId(), this);
        return true;
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
        if (!burgere.isEmpty())
            sb.setLength(sb.length() - 2);
        sb.append(']');
        return sb.toString();
    }
}
