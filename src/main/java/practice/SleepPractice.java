package practice;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/7/13.
 */
public class SleepPractice implements Runnable {

    public void run() {
        Random random = new Random();
        int i = random.nextInt(10) % (10) + 1;
        try {
            TimeUnit.MILLISECONDS.sleep(i);
            System.out.println(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService execute = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            execute.execute(new SleepPractice());
        }
        execute.shutdown();
    }
}
