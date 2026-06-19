package org.example.deadlock;
public class Deadlock {
    public static void main(String[] args) throws InterruptedException {
        Object lock1 = new Object();
        Object lock2 = new Object();

        Thread t1 = new Thread(new DeadlockTask(lock1, lock2), "Поток 1");
        Thread t2 = new Thread(new DeadlockTask(lock2, lock1), "Поток 2");

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
