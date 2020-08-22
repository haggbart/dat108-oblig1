package no.hvl.dat108.oblig1.oppgave1;

public class Main {
    public static void main(String[] args) {

        Printer printer = new Printer();
        Dialog dialog = new Dialog(printer);

        new Thread(printer).start();
        new Thread(dialog).start();
    }
}
