package chapter21;

/**
 * Created by hklv on 2016/7/21.
 */
public class ExceptionThread2 implements Runnable {


    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run by " + t);
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}
