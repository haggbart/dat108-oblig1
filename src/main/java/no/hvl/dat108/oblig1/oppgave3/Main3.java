package no.hvl.dat108.oblig1.oppgave3;

public class Main3 {

    private static final int ANTALL_KOKKER = 3;
    private static final int ANTALL_SERVITORER = 2;

    public static void main(String[] args) {
        Rutsjebane bane = Rutsjebane.getBane();

        for (int id = 1; id <= ANTALL_KOKKER; id++) {
            Kokk kokk = new Kokk(bane, "Kokk "+id);
            kokk.start();
        }

        for (int id = 1; id <= ANTALL_SERVITORER; id++) {
            Servitor servitor = new Servitor(bane,"Servitor " + id);
            servitor.start();
        }

    }
}
