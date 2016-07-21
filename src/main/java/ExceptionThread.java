import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hklv on 2016/7/15.
 */
public class ExceptionThread implements Runnable {
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
