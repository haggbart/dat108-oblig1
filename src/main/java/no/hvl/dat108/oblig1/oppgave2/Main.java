package no.hvl.dat108.oblig1.oppgave2;

public class Main {

    public static void main(String[] args) throws InterruptedException {



        Rutsjebane bane = new Rutsjebane();

        Kokk kokk1 = new Kokk(bane, "Mads");
        Kokk kokk2 = new Kokk(bane, "Kristin");
        Kokk kokk3 = new Kokk(bane, "Roger");
        Servitoer serv1 = new Servitoer(bane, "Preben");
        Servitoer serv2 = new Servitoer(bane, "Finleif");

        kokk1.start();
        kokk2.start();
//        kokk3.start();
//        serv1.start();
        serv2.start();





    }
}
