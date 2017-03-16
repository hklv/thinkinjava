package chapter21;

/**
 * 同步锁控制
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/18
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEventValue = 0;

    @Override
    public synchronized int next() {
        ++currentEventValue;
        Thread.yield();
        ++currentEventValue;
        return currentEventValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenGenerator());
    }
}
