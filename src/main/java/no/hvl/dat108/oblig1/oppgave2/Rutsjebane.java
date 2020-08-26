package no.hvl.dat108.oblig1.oppgave2;

public class Rutsjebane {
    private int bakerst;
    private Burger[] bane;

    public Rutsjebane() {
        bane = new Burger[5];
        bakerst = 0;
    }

    public synchronized void leggTil(Burger burger) throws InterruptedException {
        while (erFull()) {
            System.out.println(Thread.currentThread().getName() + " er klar med ein burger, men rutsjebanen er full. Venter!");
            wait();
        }
        bane[bakerst] = burger;
        bakerst++;
        System.out.print(Thread.currentThread().getName() + " legger på burger. " + burger.getNumber());
        printBane();
        if (bakerst == 1) { // dersom ein servitør venter, får den beskjed om at banen inneholder ein burger.
            notify();
        }
    }

    public synchronized Burger hentBurger() throws InterruptedException {
        while (erTom()) {
            System.out.println(Thread.currentThread().getName() + " vil ta ein burger, men rutsjebanen er tom. Venter!");
            wait();
        }
        Burger ut = bane[0];
        bakerst--;

        for (int i = 0; i < bakerst; i++) {
            bane[i] = bane[i + 1];
        }
        bane[bakerst] = null;
        System.out.print(Thread.currentThread().getName() + " tar av burger. " + ut.getNumber());
        printBane();
        if (bakerst == 4) { // dersom ein kokk venter, får den beskjed om at det er ledig plass på banen.
            notify();
        }
        return ut;
    }

    private synchronized boolean erFull() {
        return bakerst == 5;
    }

    public synchronized boolean erTom() {
        return bane[0] == null;
    }

    public void printBane() {
        System.out.print(" => [ ");
        for (int i = 0; i < bakerst; i++) {
            System.out.print(bane[i].getNumber() + " ");
        }
        System.out.println("]");
    }
}

