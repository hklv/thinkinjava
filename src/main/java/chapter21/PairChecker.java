package chapter21;

/**
 * Created by hklv on 2016/7/23.
 */
public class  PairChecker implements Runnable {
    private PairManager pm;

    public PairChecker(PairManager pairManager) {
        pm = pairManager;
    }

    public void run() {
        while (true) {
            pm.checkCounter.incrementAndGet();
            pm.getPair().checkState();
        }
    }
}
