package chapter21;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * MuteGenerator
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/18
 */
public class MuteEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEvenValue;
            Thread.yield();
            ++currentEvenValue;
            return currentEvenValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MuteEvenGenerator());
    }
}
