package no.hvl.dat108.oblig1.oppgave2;

public class Kokk extends Thread {

    private final Rutsjebane rutsjebane;

    public Kokk(Rutsjebane rutsjebane) {
        this.rutsjebane = rutsjebane;
    }

    @Override
    public void run() {

    }

    private Burger lagBurger() {
        return new Burger();
    }

}
