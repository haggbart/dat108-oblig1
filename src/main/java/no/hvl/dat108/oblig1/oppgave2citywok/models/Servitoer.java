package no.hvl.dat108.oblig1.oppgave2citywok.models;

public class Servitoer implements Runnable {

    private final int id;
    private final String navn;

    public Servitoer(int id, String navn) {
        this.id = id;
        this.navn = navn;
    }

    @Override
    public void run() {

    }
}
