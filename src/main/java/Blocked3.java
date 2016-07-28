import java.util.concurrent.TimeUnit;

/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/28
 */
public class Blocked3 implements Runnable {
    private volatile double d = 0.0;

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                NeedCleanup n1 = new NeedCleanup(1);
                try {
                    System.out.println("sleep");
                    TimeUnit.SECONDS.sleep(1);
                    NeedCleanup n2 = new NeedCleanup(2);
                    try {
                        System.out.println("Calculating");
                        for (int i = 1; i < 2500000; i++) {
                            d = d + (Math.PI + Math.E) / d;
                        }
                        System.out.println("finished time-consuming operation");
                    } finally {
                        n2.cleanup();
                    }
                } finally {
                    n1.cleanup();
                }
            }
            System.out.println("Exiting via while() test");
        } catch (Exception e) {
            System.out.println("Exiting via InterruptedException");
        }

    }
}
