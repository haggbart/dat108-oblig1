package no.hvl.dat108.oblig1.oppgave3;

import no.hvl.dat108.oblig1.oppgave3.models.Kokk;
import no.hvl.dat108.oblig1.oppgave3.models.Rutsjebane;
import no.hvl.dat108.oblig1.oppgave3.models.Servitoer;

import java.util.ArrayList;
import java.util.List;

import static no.hvl.dat108.oblig1.oppgave3.helpers.Utility.currentTime;

public class App {

    private static final int ANTALL_KOKKER = 3;
    private static final int ANTALL_SERVITOERER = 2;
    private static final int AAPNINGSTID_SEKUNDER = 30;

    private static final List<Thread> threads = new ArrayList<>(ANTALL_KOKKER + ANTALL_SERVITOERER);


    public static void main(String[] args) {


        // inititere kokker
        for (int id = 1; id <= ANTALL_KOKKER; id++) {
            var thread = new Thread(new Kokk(id));
            threads.add(thread);
            thread.start();
        }

        // initiere servitører
        for (int id = 1; id <= ANTALL_SERVITOERER; id++) {
            var thread = new Thread(new Servitoer(id));
            threads.add(thread);
            thread.start();
        }

        ventTilStengetid();
        gjoerFerdigBestillinger();
    }

    private static void ventTilStengetid() {
        try {
            Thread.sleep(AAPNINGSTID_SEKUNDER * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Rutsjebane.getInstance().steng();
    }

    private static void gjoerFerdigBestillinger() {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.printf("[%s] ### Hamburger-sjappen er stengt! ###\n", currentTime());
    }
}
