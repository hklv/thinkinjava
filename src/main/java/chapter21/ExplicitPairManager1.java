package chapter21;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hklv on 2016/7/23.
 */
public class ExplicitPairManager1 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override
    public synchronized void increment() {

        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            store(getPair());
        } finally {
            lock.unlock();
        }
    }
}
