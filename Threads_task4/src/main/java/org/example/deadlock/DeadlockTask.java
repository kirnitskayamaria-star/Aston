package org.example.deadlock;

public class DeadlockTask implements Runnable{
    private final Object Lock1;
    private final Object Lock2;


    public DeadlockTask(Object lock1, Object lock2) {
        this.Lock1 = lock1;
        this.Lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (Lock1) {
            System.out.println(Thread.currentThread().getName() + " удерживает " + Lock1);
            try { Thread.sleep(100); } catch (InterruptedException e) {}
            synchronized (Lock2) {
                System.out.println("Deadlock не сработал");
            }
        }
    }
}
