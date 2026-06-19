package org.example.sequence;

public class SequenceOutputTask implements Runnable{
    private final Object monitor;
    private final int number;
    private final boolean myTurn;

    private static volatile boolean isFirstTurn = true;

    public SequenceOutputTask(Object monitor, int number, boolean myTurn) {
        this.monitor = monitor;
        this.number = number;
        this.myTurn = myTurn;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (monitor) {
                while (isFirstTurn != myTurn) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                System.out.print(number + " ");
                isFirstTurn = !isFirstTurn;

                monitor.notifyAll();
            }
        }
    }
}
