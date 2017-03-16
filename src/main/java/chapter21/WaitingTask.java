package chapter21;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hklv on 2016/8/2.
 */
public class WaitingTask implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;

    public WaitingTask(CountDownLatch l) {
        latch = l;
    }

    public void run() {
        try {
            latch.await();
            System.out.println("Latch barrier passed for " + this);
        } catch (InterruptedException e) {
            System.out.println(this + " interrupted");
        }

    }

    public String toString() {
        return "chapter21.WaitingTask %1$-3d " + id;
    }
}
