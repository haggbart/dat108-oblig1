package no.hvl.dat108.oblig1.oppgave2;

public class Burger {

    private int typenummer;

    Burger() {
        this.typenummer = (int)(Math.random() * 3);
    }

    Burger(int typenummer) {
        this.typenummer = typenummer;
    }

    public int getTypenummer() {
        return typenummer;
    }

    public String getType() {
        if (typenummer == 0) {
            return "Cheeseburger";
        }
        if (typenummer == 1) {
            return "Burger";
        }
        if (typenummer == 2) {
            return "Baconburger";
        }

        else return "Mystisk burger";
    }
}
