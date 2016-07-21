import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hklv on 2016/7/21.
 */
public class CaptureUncaughtException {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
