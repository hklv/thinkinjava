import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/7/23.
 */
public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value = new ThreadLocal<Integer>() {
        private Random random = new Random(47);
        protected synchronized Integer initialValue() {
            return random.nextInt(10000);
        }
    };

    public static void increment() {
        value.set(value.get() + 1);
    }

    public static int get() {
        return value.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Accessor(i));
        }
        TimeUnit.MILLISECONDS.sleep(3);
        executorService.shutdownNow();
    }
}
