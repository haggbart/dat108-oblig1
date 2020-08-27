package no.hvl.dat108.oblig1.oppgave3;

public class Burger {
    private String number;
    private static int teller = 0;

    public Burger() {
        number = "("+ nyttBurgerNummer() +")";
    }

    private int nyttBurgerNummer() {
        teller++;
        return teller;
    }

    public String getNumber() {
        return number;
    }
}
