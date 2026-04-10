package org.example.livelock;

public class Livelock {
    public static void main(String[] args) throws InterruptedException {
        LivelockTask task1 = new LivelockTask("Поток 1");
        LivelockTask task2 = new LivelockTask("Поток 2");


        task1.setPartner(task2);
        task2.setPartner(task1);

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}