package no.hvl.dat108.oblig1.oppgave3citywok.models;

public class Servitoer extends Ansatt implements Runnable {

    public Servitoer(int id) {
        super(id);
    }

    @Override
    public void run() {

        while (rutsjebane.mottarOrdre() || !rutsjebane.isEmpty()) {
            work();
            rutsjebane.take(this);
        }
    }
}
