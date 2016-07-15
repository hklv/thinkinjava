import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/7/15.
 */
public class InnerRunnable2 {
    private int countDown = 5;
    private Thread t;

    public InnerRunnable2(String name) {
        t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("interrupted");
                    }
                }
            }

            public String toString() {
                return Thread.currentThread().getName() + ": " + countDown;
            }
        }, name);
        t.start();
    }
}
