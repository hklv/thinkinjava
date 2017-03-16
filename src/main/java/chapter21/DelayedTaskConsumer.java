package chapter21;

import java.util.concurrent.DelayQueue;

/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/8/3
 */
public class DelayedTaskConsumer implements Runnable {
    private DelayQueue<DelayedTask> q;

    public DelayedTaskConsumer(DelayQueue<DelayedTask> q) {
        this.q = q;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                q.take().run();
            }
        } catch (InterruptedException e) {

        }
        System.out.println("Finished chapter21.DelayedTask");
    }
}
