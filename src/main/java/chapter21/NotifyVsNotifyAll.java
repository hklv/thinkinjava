package chapter21;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/30
 */
public class NotifyVsNotifyAll {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Task());
        }
        exec.execute(new Task2());
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            boolean prod = true;

            @Override
            public void run() {
                if (prod) {
                    System.out.println("\nnotify()");
                    Task.blocker.prod();
                    prod = false;
                } else {
                    System.out.println("\nnotifyAll()");
                    Task.blocker.prodAll();
                    prod = true;
                }
            }
        }, 400, 400);

        TimeUnit.SECONDS.sleep(5);
        timer.cancel();
        System.out.println("\nTimer canceled");
        TimeUnit.MICROSECONDS.sleep(500);
        System.out.println("chapter21.Task2.blocker.prodAll()");
        Task2.blocker.prodAll();
        TimeUnit.MICROSECONDS.sleep(500);
        System.out.println("\nshutting down");
        exec.shutdownNow();
    }
}
