package no.hvl.dat108.oblig1.oppgave2;

public class Main2 {
    public static void main(String[] args) {
        Rutsjebane bane = new Rutsjebane();

        Kokk kokk1 = new Kokk(bane,"Kokk1");
        Kokk kokk2 = new Kokk(bane,"Kokk2");
        Kokk kokk3 = new Kokk(bane,"Kokk3");

        Servitor servitor1 = new Servitor(bane, "Servitor1");
        Servitor servitor2 = new Servitor(bane, "Servitor2");

        kokk1.start();
        kokk2.start();
        kokk3.start();
        servitor1.start();
        servitor2.start();
    }
}