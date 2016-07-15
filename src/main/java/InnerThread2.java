import java.util.concurrent.TimeUnit;

/**
 * InnerThread2
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/15
 */
public class InnerThread2 {
    private int countDown = 5;

    private Thread t;

    public InnerThread2(String name) {
        t = new Thread(name) {
            public void run() {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) return;
                    try {
                        TimeUnit.MICROSECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted");
                    }
                }
            }

            public String toString() {
                return getName() + " : " + countDown;
            }
        };

        t.start();
    }
}
