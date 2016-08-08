import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/8/8.
 */
public class SemaphoreDemo {
    final static int SIZE = 0;

    public static void main(String[] args) throws InterruptedException {
        final Pool<Fat> pool = new Pool<Fat>(Fat.class, SIZE);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < SIZE; i++) {
            exec.execute(new CheckoutTask<Fat>(pool));
        }
        System.out.println("All CheckoutTask created");
        List<Fat> fatList = new ArrayList<Fat>();
        for (int i = 0; i < SIZE; i++) {
            Fat f = new Fat();
            System.out.println(i + ": main() thread checked out ");
            f.operation();
            fatList.add(f);
        }

        Future<?> blocked = exec.submit(new Runnable() {
            public void run() {
                try {
                    pool.checkOut();
                } catch (InterruptedException e) {

                }
            }
        });
        TimeUnit.SECONDS.sleep(2);
        blocked.cancel(true);
        for (Fat f : fatList) {
            pool.checkIn(f);
        }
        for (Fat f : fatList) {
            pool.checkIn(f);
        }
        exec.shutdown();
    }


}
