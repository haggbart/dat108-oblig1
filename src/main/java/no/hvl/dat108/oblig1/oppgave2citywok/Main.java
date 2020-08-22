package no.hvl.dat108.oblig1.oppgave2citywok;

import com.github.javafaker.Faker;
import no.hvl.dat108.oblig1.oppgave2citywok.models.Kokk;
import no.hvl.dat108.oblig1.oppgave2citywok.models.Servitoer;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {

        Faker faker = new Faker(new Locale("nb-no"));

        // inititere kokker
        for (int i = 1; i <= 3; i++) {
            new Thread(new Kokk(i, faker.name().firstName())).start();
        }

        // initiere servitører
        for (int i = 1; i <= 2; i++) {
            new Thread(new Servitoer(i, faker.name().firstName()));
        }
    }
}
