package chapter21;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/8/4.
 */
public class PrioritizedTaskProducer implements Runnable {
    private Random random = new Random(47);
    private Queue<Runnable> queue;
    private ExecutorService exec = Executors.newCachedThreadPool();

    public PrioritizedTaskProducer(Queue<Runnable> q, ExecutorService e) {
        queue = q;
        exec = e;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            queue.add(new PrioritizedTask(random.nextInt(10)));
            Thread.yield();
        }
        try {
            for (int i = 0; i < 10; i++) {
                TimeUnit.MILLISECONDS.sleep(250);
                queue.add(new PrioritizedTask(random.nextInt(10)));
            }
        } catch (InterruptedException e) {

        }
        for (int i = 0; i < 10; i++) {
            queue.add(new PrioritizedTask(i));
        }
        System.out.println("Finished chapter21.PrioritizedTaskProducer");
    }


}
