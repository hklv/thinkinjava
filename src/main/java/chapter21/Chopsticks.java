package chapter21;

/**
 * Created by hklv on 2016/8/1.
 */
public class Chopsticks {
    private boolean taken = false;

    public synchronized void take() throws InterruptedException {
        while (taken) {
            wait();
        }
        taken = true;
    }

    public synchronized void drop() throws InterruptedException {
        taken = false;
        notifyAll();
    }
}
