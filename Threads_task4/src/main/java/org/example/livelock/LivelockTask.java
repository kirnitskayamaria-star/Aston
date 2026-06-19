package org.example.livelock;

public class LivelockTask implements Runnable{
    private final String name;
    private volatile boolean active = true;

    private LivelockTask partner;
    public LivelockTask(String name) {
        this.name = name;
    }

    public void setPartner(LivelockTask partner) {
        this.partner = partner;
    }

    @Override
    public void run() {

        while (active) {
            if (partner != null && partner.active) {
                System.out.println(name + ": уступаю");
                active = false;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                active = true;
            }
        }
        System.out.println("Livelock не сработал!");
    }
}
