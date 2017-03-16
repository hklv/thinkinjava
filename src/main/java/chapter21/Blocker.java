package chapter21;

/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/30
 */
public class Blocker {
    synchronized void waitingCall() {
        try {
            while (!Thread.interrupted()) {
                wait();
                System.out.println(Thread.currentThread() + " ");
            }
        } catch (InterruptedException e) {

        }
    }

    synchronized void prod() {
        notify();
    }

    synchronized void prodAll() {
        notifyAll();
    }
}
