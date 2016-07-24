import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/7/24.
 */
public class SleepBlocked implements Runnable {
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception");
        }
        System.out.println("Exiting SleepBlocked.run");
    }
}
