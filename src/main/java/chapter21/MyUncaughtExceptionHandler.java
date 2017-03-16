package chapter21;

/**
 * Created by hklv on 2016/7/21.
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " + e);
    }
}
