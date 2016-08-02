import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hklv on 2016/8/2.
 */
public class CountDownLatchDemo {
    static final int SIZE = 10;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++) {
            exec.execute(new WaitingTask(latch));
        }
        for (int i = 0; i < 10; i++) {
            exec.execute(new TaskPortion(latch));
        }
        System.out.println("lauched all task");
        exec.shutdown();
    }
}
