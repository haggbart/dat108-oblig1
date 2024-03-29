package no.hvl.dat108.oblig1.oppgave2citywok.models;

public class Kokk extends Ansatt implements Runnable {

    public Kokk(int id) {
        super(id);
    }

    @Override
    public void run() {
        while (rutsjebane.mottarOrdre()) {
            work();
            rutsjebane.leggPaaBurger(this, new Hamburger());
        }
    }
}
