import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/8/1.
 */
public class Toast0Matic {
    public static void main(String[] args) throws Exception {
        ToastQueue dryQueue = new ToastQueue(), butterQueue = new ToastQueue(), finishedQueue = new ToastQueue();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new Toaster(dryQueue));
        exec.execute(new Butterer(dryQueue, butterQueue));
        exec.execute(new Jamer(butterQueue, finishedQueue));
        exec.execute(new Eater(finishedQueue));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
