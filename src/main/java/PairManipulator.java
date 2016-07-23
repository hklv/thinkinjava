/**
 * Created by hklv on 2016/7/23.
 */
public class PairManipulator implements Runnable {
    private PairManager pm;

    public PairManipulator(PairManager pairManager) {
        this.pm = pairManager;
    }

    public void run() {
        while (true) {
            pm.increment();
        }
    }

    public String toString() {
        return "Pair: " + pm.getPair() + " checkCounter= " + pm.checkCounter;
    }
}
