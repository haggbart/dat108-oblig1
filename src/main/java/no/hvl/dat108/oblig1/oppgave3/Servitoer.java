package no.hvl.dat108.oblig1.oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Servitoer extends Thread {

    private final BlockingQueue<Burger> bq;
    private Random random = new Random();
    private String navn;


    public Servitoer(BlockingQueue<Burger> bq, String navn) {
        this.bq = bq;
        this.setName(navn);

    }

    @Override
    public void run() {


        while (true) {

            try {

                Thread.sleep(random.nextInt(4000) + 2000);
                if(bq.isEmpty()) {
                    System.out.print(this.getName() + " venter på å hente ut burger \n");
                }
                Burger hentetBurger = bq.take();
                System.out.print(this.getName() + " henter ut en [" + hentetBurger.getId() + "]" +hentetBurger.getType() + " <= " + bq + "\n");


            } catch (InterruptedException e) {
                e.printStackTrace();
            }



        }
    }
}