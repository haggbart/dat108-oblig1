package no.hvl.dat108.oblig1.oppgave3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Rutsjebane {
    private final static int storleik = 5;
    private final static Rutsjebane bane = new Rutsjebane();
    private final BlockingQueue<Burger> burgers;

    private Rutsjebane() {
        this.burgers = new ArrayBlockingQueue<>(storleik);
    }

    public static Rutsjebane getBane() {
        return bane;
    }


    public void leggTil(Burger burger) {
        if (storleik == burgers.size()) {
            System.out.println(Thread.currentThread().getName() + " er klar med ein burger, men rutsjebanen er full. Venter!");
        }

        try {
            burgers.put(burger);
            synchronized (burgers) {
                System.out.print(Thread.currentThread().getName() + " legger på burger. " + burger.getNumber());
                printBane();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Burger hentBurger() {
        if (burgers.size() == 0) {
            System.out.println(Thread.currentThread().getName() + " vil ta ein burger, men rutsjebanen er tom. Venter!");
        }

        try {
            Burger ut = burgers.take();
            synchronized (burgers) {
                System.out.print(Thread.currentThread().getName() + " tar av burger. " + ut.getNumber());
                printBane();
            }
            return ut;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void printBane() {
        System.out.print(" => [ ");
        for (Burger b : burgers) {
            System.out.print(b.getNumber() + " ");
        }
        System.out.println("]");
    }

}
