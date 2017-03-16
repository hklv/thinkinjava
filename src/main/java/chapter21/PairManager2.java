package chapter21;

/**
 * Created by hklv on 2016/7/23.
 */
public class PairManager2 extends PairManager {
    @Override
    public void increment() {
        Pair temp;
        synchronized (this) {
            p.incrementX();
            p.incrementY();
            temp = getPair();
        }
        store(temp);
    }
}
