package no.hvl.dat108.oblig1.oppgave2;

public class Rutsjebane {

    private int bak;
    private Burger[] bane;
    private Burger burger;

    public Rutsjebane() {
        bane = new Burger[5];
        bak = 0;
    }

    public synchronized void leggTil(Burger burger) throws InterruptedException {

        if(bak == 5) {
            Thread.currentThread().wait();
        }
        bane[bak] = burger;
        bak++;
        System.out.print(Thread.currentThread().getName() + " legger til en " + burger.getType() + " => ");
        notify();

    }

    public synchronized Burger hentBurger() throws InterruptedException {

        if(bak == 0) {
            Thread.currentThread().join();
        }
        Burger ut = bane[0];
        bak--;

        for(int i = 0; i < bak; i++) {
            bane[i] = bane[i+1];
        }
        bane[bak] = null;
        System.out.print(Thread.currentThread().getName() + " henter ut en " + ut.getType() + " <= ");


        return ut;
    }

    public String peek() {
        return bane[0].getType();
    }

    public synchronized boolean erFull() {
        return bak == 5;
    }

    public synchronized boolean erTom() { return bane[0] == null; }

    public synchronized void printBane() {

        System.out.print("Burgere i banen: ");

        for(int i = 0; i < bak; i++) {

            System.out.print(bane[i].getType() + " ");
        }
    }

}