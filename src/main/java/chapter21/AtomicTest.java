package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * chapter21.AtomicTest
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/22
 */
public class AtomicTest implements Runnable {
    private volatile int i = 0;

    public int getValue() {
        return i;
    }

    public synchronized void evenIncrement() {
        i++;
        i++;
    }

    @Override
    public void run() {
        while (true) {
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicTest at = new AtomicTest();
        exec.execute(at);
        while (true) {
            int val = at.getValue();
            if (val % 2 != 0) {
                System.out.println(val);
                System.exit(0);
            }
        }
    }
}
