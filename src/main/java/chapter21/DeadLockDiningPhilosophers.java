package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/8/2.
 */
public class DeadLockDiningPhilosophers {
    public static void main(String[] args) throws Exception {
        int ponder = 5;
        if (args.length > 0) {
            ponder = Integer.parseInt(args[0]);
        }
        int size = 5;
        if (args.length > 1) {
            size = Integer.parseInt(args[1]);
        }
        ExecutorService exec = Executors.newCachedThreadPool();
        Chopsticks[] chopsticks = new Chopsticks[size];
        for (int i = 0; i < size; i++) {
            chopsticks[i] = new Chopsticks();
        }
        for (int i = 0; i < size; i++) {
            exec.execute(new Philosopher(chopsticks[i], chopsticks[(i + 1) % size], i, ponder));
        }
        if (args.length == 3 && args[2].equals("timeout")) {
            TimeUnit.SECONDS.sleep(5);
        } else {
            System.out.println("Press Enter to quit");
            System.in.read();
        }
        exec.shutdownNow();
    }
}
