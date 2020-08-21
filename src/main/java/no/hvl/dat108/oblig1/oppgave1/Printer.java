package no.hvl.dat108.oblig1.oppgave1;

public class Printer implements Runnable {

    private boolean isRunning = true;
    private String message = "Hei verdenen!";

    @Override
    public void run() {

        printMessage();
    }

    private void printMessage() {
        while (isRunning) {
            System.out.println(message);
            synchronized (this) {
                try {
                    wait(3000); // instantly wakes up on quit
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Exited.");
    }

    public synchronized void quit() {
        isRunning = false;
        notify(); // notifies the first thread that has a lock on this object
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
