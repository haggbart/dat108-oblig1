package no.hvl.dat108.oblig1.oppgave1;

import static javax.swing.JOptionPane.showInputDialog;

public class Dialog implements Runnable {

    private final Printer printer;

    public Dialog(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        String DIALOG = "Skriv inn din melding, trykk cancel eller skriv 'quit' for å avslutte.";
        String input;

        while ((input = showInputDialog(DIALOG)) != null
                && !input.equalsIgnoreCase("quit")) {
            printer.setMessage(input);
        }
        System.out.println("Shutting down...");
        printer.quit();
    }
}
