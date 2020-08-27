package no.hvl.dat108.oblig1.oppgave3;

public class Burger {
    private String burgerID;
    private static int teller = 0;

    public Burger() {
        burgerID = "(" + nyttBurgerNummer() + ")";
    }

    private int nyttBurgerNummer() {
        return ++teller;
    }

    public String getBurgerID() {
        return burgerID;
    }
}
