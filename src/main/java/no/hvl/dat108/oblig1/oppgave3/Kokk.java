package no.hvl.dat108.oblig1.oppgave3;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Kokk extends Thread {

    private final BlockingQueue<Burger> bq;
    private Random random = new Random();
    private String navn;

    public Kokk(BlockingQueue<Burger> bq, String navn) {
        this.bq = bq;
        this.setName(navn);

    }

    @Override
    public void run() {



        while(true) {



            try {
                Thread.sleep(random.nextInt(4000) + 2000);
                Burger nyBurger = new Burger();
                if(bq.remainingCapacity() == 0) {
                    System.out.println(this.getName() + " prøver å legge til en " + nyBurger.getType() + ", men køen er full");
                }
                bq.put(nyBurger);
                System.out.print(this.getName() + " legger til en [" + nyBurger.getId() + "]" + nyBurger.getType() + " => " + bq + "\n");



            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }
}
