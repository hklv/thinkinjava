package chapter21;

import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/8/8.
 */
public class CheckoutTask<T> implements Runnable {
    private static int counter = 0;
    private final int id = counter++;
    private Pool<T> pool;

    public CheckoutTask(Pool<T> pool) {
        this.pool = pool;
    }

    public void run() {
        try {
            T item = pool.checkOut();
            System.out.println(this + "check out " + item);
            TimeUnit.MILLISECONDS.sleep(1);
            System.out.println(this + "check in " + item);
            pool.checkIn(item);
        } catch (InterruptedException e) {

        }
    }

    public String toString() {
        return "checkout task " + id;
    }


}
