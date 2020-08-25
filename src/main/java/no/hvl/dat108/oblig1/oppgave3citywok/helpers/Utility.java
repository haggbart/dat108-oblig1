package no.hvl.dat108.oblig1.oppgave3citywok.helpers;

import java.time.LocalTime;

public class Utility {

    public static String currentTime() {
        var time = LocalTime.now();
        return String.format("%02d:%02d", time.getMinute(), time.getSecond());
    }

    public static final String[] COLOR = new String[]{
            "\u001B[0m",
            "\u001B[30m",
            "\u001B[31m",
            "\u001B[32m",
            "\u001b[33m",
            "\u001B[34m",
            "\u001B[35m",
            "\u001B[36m",
            "\u001b[37m",
    };

    public static int colorIndex = 0;

    public static String getNextColor() {
        colorIndex = (colorIndex + 2) % COLOR.length - 1;
        return COLOR[colorIndex];
    }

    public static String resetColor() {
        return COLOR[0];
    }
}
