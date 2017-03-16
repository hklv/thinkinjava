package chapter21;

import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by hklv on 2016/8/4.
 */
public class PrioritizedTaskConsumer implements Runnable {
    private PriorityBlockingQueue<Runnable> q;

    public PrioritizedTaskConsumer(PriorityBlockingQueue<Runnable> queue) {
        this.q = queue;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                q.take().run();
            }
        } catch (InterruptedException e) {

        }
        System.out.println("Finished chapter21.PrioritizedTaskConsumer");
    }

}
