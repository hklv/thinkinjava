package chapter21;

/**
 * Created by hklv on 2016/7/23.
 */
public class PairManager1 extends PairManager{
    @Override
    public synchronized void increment() {
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
