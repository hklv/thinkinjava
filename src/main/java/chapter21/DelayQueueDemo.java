package chapter21;

import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/8/3
 */
public class DelayQueueDemo {
    public static void main(String[] args) {
        Random rand = new Random(47);
        ExecutorService exec = Executors.newCachedThreadPool();
        DelayQueue<DelayedTask> queue = new DelayQueue<DelayedTask>();
        for (int i = 0; i < 20; i++) {
            queue.put(new DelayedTask(rand.nextInt(5000)));
        }
        queue.add(new DelayedTask.EndSentinel(5000, exec));
        exec.execute(new DelayedTaskConsumer(queue));
    }
}
