import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hklv   on 2016/7/21.
 */
public class SettingDefaultHandler {
    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
