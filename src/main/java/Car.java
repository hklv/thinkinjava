/**
 * Created by hklv on 2016/7/28.
 */
public class Car {
    private boolean waxOn = false;

    public synchronized void waxed() {
        waxOn = true;
        notifyAll();
    }

    public synchronized void buffered() {
        waxOn = false;
        notifyAll();
    }

    public synchronized void waitingForWaxing() throws InterruptedException {
        while (waxOn == false) {
            wait();
        }
    }

    public synchronized void waitingForBuffing() throws InterruptedException {
        while (waxOn == true) {
            wait();
        }
    }
}
