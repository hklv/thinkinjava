package chapter21;

import java.util.concurrent.TimeUnit;

/**
 * chapter21.InnerThread
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/15
 */
public class InnerThread {
    private int countDown = 5;
    private Inner inner;

    private class Inner extends Thread {
        public Inner(String name) {
            super(name);
            start();
        }

        public void run() {
            while (true) {
                System.out.println(this);
                if (--countDown == 0) return;
                try {
                    TimeUnit.MICROSECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }
        }

        public String toString() {
            return getName() + "(" + countDown + ")";
        }
    }

    public InnerThread(String name) {
        new Inner(name);
    }
}
