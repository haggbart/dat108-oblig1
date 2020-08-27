package no.hvl.dat108.oblig1.oppgave3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Rutsjebane {
    private final static int storleik = 5;
    private final static Rutsjebane bane = new Rutsjebane();
    private final BlockingQueue<Burger> burgers;

    private ReentrantLock venteliste;

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
                System.out.print(Thread.currentThread().getName() + " legger på burger " + burger.getBurgerID() + ".");
                printBane();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void hentBurger() {
        if (burgers.size() == 0) {
            System.out.println(Thread.currentThread().getName() + " vil ta ein burger, men rutsjebanen er tom. Venter!");
        }

        try {
            Burger ut = burgers.take();
            synchronized (burgers) {
                System.out.print(Thread.currentThread().getName() + " tar av burger " + ut.getBurgerID() + ".");
                printBane();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printBane() {
        System.out.print(" => [ ");
        for (Burger b : burgers) {
            System.out.print(b.getBurgerID() + " ");
        }
        System.out.println("]");
    }

}
