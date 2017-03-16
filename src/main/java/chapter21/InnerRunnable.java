package chapter21;

import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/7/15.
 */
public class InnerRunnable {
    private int countDown = 5;
    private Inner inner;

    private class Inner implements Runnable {
        Thread t;

        Inner(String name) {
            t = new Thread(this, name);
            t.start();
        }

        public void run() {
            while (true) {
                System.out.println(this);
                if (--countDown == 0) {
                    return;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }
        }

        public String toString() {
            return t.getName() + ": " + countDown;
        }

    }

    public InnerRunnable(String name) {
        new Inner(name);
    }
}
