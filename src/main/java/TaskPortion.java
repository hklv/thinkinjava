import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/8/2.
 */
public class TaskPortion implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Random random = new Random(47);
    private final CountDownLatch latch;

    public TaskPortion(CountDownLatch countDownLatch) {
        this.latch = countDownLatch;
    }

    public void run() {
        try {
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {
            System.out.println("interrupt");
        }
    }

    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(random.nextInt(2000));
        System.out.println(this + "completed");
    }

    public String toString() {
        return String.format("%1$-3d", id);
    }
}
