package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/7/24.
 */
public class OrnamentalGarden {
    public static void main(String[] args) throws Exception {

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Entrance(i));
        }
        TimeUnit.MILLISECONDS.sleep(3);
        Entrance.cancel();
        exec.shutdown();
        if (!exec.awaitTermination(250, TimeUnit.MICROSECONDS)) {
            System.out.println("Some tasks ware not terminated");
        }

        System.out.println("Total: " + Entrance.getTotalCount());
        System.out.println("Sum of entrance: " + Entrance.getSumEntrance());
    }
}
