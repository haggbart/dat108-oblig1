package no.hvl.dat108.oblig1.oppgave2citywok.helpers;

import java.time.LocalTime;

public class Utility {

    public static String currentTime() {
        var time = LocalTime.now();
        return String.format("%02d:%02d", time.getMinute(), time.getSecond());
    }
}
