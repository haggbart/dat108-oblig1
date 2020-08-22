package no.hvl.dat108.oblig1.oppgave2;

public class Rutsjebane {

    private int bak;
    private Burger[] bane;

    public Rutsjebane() {
        bane = new Burger[5];
        bak = 0;
    }

    public void leggTil(Burger burger) throws InterruptedException {

        if(bak == 5) {
            Thread.currentThread().join();
        }
        bane[bak] = burger;
        bak++;
    }

    public Burger hentBurger() throws InterruptedException {

        if(bak == 0) {
            Thread.currentThread().join();
        }
        Burger ut = bane[0];
        bak--;

        for(int i = 0; i < bak; i++) {
            bane[i] = bane[i+1];
        }
        bane[bak] = null;
        return ut;
    }

    public String peek() {
        return bane[0].getType();
    }

    public void printBane() {

        System.out.print("Burgere i banen: ");

        for(int i = 0; i < bak; i++) {

            System.out.print(bane[i].getType() + " ");
        }
    }

}