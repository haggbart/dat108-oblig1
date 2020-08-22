package no.hvl.dat108.oblig1.oppgave2citywok;

import com.github.javafaker.Faker;
import no.hvl.dat108.oblig1.oppgave2citywok.models.Kokk;
import no.hvl.dat108.oblig1.oppgave2citywok.models.Servitoer;

import java.util.Locale;

public class Main {

    private static final int ANTALL_KOKKER = 3;
    private static final int ANTALL_SERVITOERER = 2;
    private static final int RUNTIME_SECONDS = 20;
    private static final Locale LOCALE = new Locale("nb-no");

    public static void main(String[] args) {

        Faker faker = new Faker(LOCALE);

        // inititere kokker
        for (int i = 1; i <= ANTALL_KOKKER; i++) {
            new Thread(new Kokk(i, faker.name().firstName())).start();
        }

        // initiere servitører
        for (int i = 1; i <= ANTALL_SERVITOERER; i++) {
            new Thread(new Servitoer(i, faker.name().firstName())).start();
        }


        // avslutte programmet på etter 20 sekunder
        try {
            Thread.sleep(RUNTIME_SECONDS * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        System.exit(0);
    }
}
