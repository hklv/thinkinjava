import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hklv on 2016/7/30.
 */
public class Car1 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean waxOn = false;

    public void waxed() {
        lock.lock();
        try {
            waxOn = true;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void buffed() {
        lock.lock();
        try {
            waxOn = false;
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void waitingForWaxing(Condition condition) throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == false) {
                condition.wait();
            }
        } finally {
            lock.unlock();
        }
    }

    public void waitingForBuffing(Condition conditon) throws InterruptedException {
        lock.lock();
        try {
            while (waxOn == true) {
                condition.await();
            }
        } finally {
            lock.unlock();
        }
    }
}
