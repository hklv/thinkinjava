package chapter21;

import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/7/15.
 */
public class ThreadMethod {
    private int countDown = 5;
    private Thread t;
    private String name;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        if (t == null) {
            t = new Thread(name) {
                public void run() {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) return;
                        try {
                            TimeUnit.MILLISECONDS.sleep(11);
                        } catch (InterruptedException e) {
                            System.out.println("sleep interrupted");
                        }
                    }
                }

                public String toString() {
                    return getName() + ": " + countDown;
                }
            };
        }
        t.start();
    }
}
