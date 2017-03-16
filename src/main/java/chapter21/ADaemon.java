package chapter21;

import java.util.concurrent.TimeUnit;

/**
 * Adaemon
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/14
 */
public class ADaemon implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("Starting A");
            TimeUnit.MICROSECONDS.sleep(1);
        } catch (InterruptedException e) {
            System.out.println("Exiting via Interrupted");
        } finally {
            System.out.println("This would always run?");
        }
    }
}
