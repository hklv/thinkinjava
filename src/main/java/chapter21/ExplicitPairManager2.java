package chapter21;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hklv on 2016/7/23.
 */
public class ExplicitPairManager2 extends PairManager {
    private Lock lock = new ReentrantLock();

    @Override
    public void increment() {
        Pair temp;
        lock.lock();
        try {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        } finally {
            lock.unlock();
        }
        store(temp);
    }
}
