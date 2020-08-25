package no.hvl.dat108.oblig1.oppgave3citywok.models;

public class Servitoer extends Ansatt implements Runnable {

    public Servitoer(int id) {
        super(id);
    }

    @Override
    public void run() {

        while (rutsjebane.mottarOrdre() || !rutsjebane.isEmpty()) {

            synchronized (this) {
                try {
                    wait(random.nextInt(4000) + 2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                rutsjebane.take(this);
            }
        }
    }
}
