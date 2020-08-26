package no.hvl.dat108.oblig1.oppgave3citywok.models;

public class Kokk extends Ansatt implements Runnable {

    public Kokk(int id) {
        super(id);
    }

    @Override
    public void run() {
        while (rutsjebane.mottarOrdre()) {

            synchronized (this) {
                try {
                    wait(random.nextInt(4000) + 2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rutsjebane.add(this, new Hamburger());
            }
        }
    }
}
