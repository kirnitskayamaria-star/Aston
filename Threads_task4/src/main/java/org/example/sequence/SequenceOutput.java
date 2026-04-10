package org.example.sequence;

public class SequenceOutput {
    public static void main(String[] args) throws InterruptedException {
        Object monitor = new Object();

        Thread t1 = new Thread(new SequenceOutputTask(monitor, 1, true));
        Thread t2 = new Thread(new SequenceOutputTask(monitor, 2, false));

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}
