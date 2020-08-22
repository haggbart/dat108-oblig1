package no.hvl.dat108.oblig1.oppgave2;

public class Main {

    public static void main(String[] args) throws InterruptedException {


        Burger test = new Burger();
        Burger test2 = new Burger();
        Burger test3 = new Burger();
        Burger test4 = new Burger();
        Burger test5 = new Burger();
        Burger test6 = new Burger();

        Rutsjebane bane = new Rutsjebane();

        new Kokk(bane);

        bane.leggTil(test);
        bane.leggTil(test2);
        bane.leggTil(test3);
        bane.leggTil(test4);
        bane.leggTil(test5);
        bane.leggTil(test6);

        bane.printBane();
        System.out.println();
        bane.hentBurger();

        bane.printBane();




    }
}
