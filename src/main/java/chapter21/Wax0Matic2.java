package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/7/31.
 */
public class Wax0Matic2 {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOff1(car));
        exec.execute(new WaxOn1(car));
        TimeUnit.SECONDS.sleep(5);
        exec.shutdownNow();
    }
}
