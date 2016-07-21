import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hklv on 2016/7/15.
 */
public class NaiveExceptionHanding {
    public static void main(String[] args) {
        try {
            ExecutorService exec = Executors.newCachedThreadPool();

            exec.execute(new ExceptionThread());
        } catch (RuntimeException e) {
            System.out.println("Exception has been handled");
        }
    }

}
