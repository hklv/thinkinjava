/**
 * Created by hklv on 2016/7/24.
 */
public class SynchronizedBlocked implements Runnable {
    public synchronized void f() {
        while (true) {
            Thread.yield();
        }
    }

    public SynchronizedBlocked() {
        new Thread() {
            public void run() {
                f();
            }
        }.start();
    }

    public void run() {
        System.out.println("Trying to call f()");
        f();
        System.out.println("Exiting SynchronizedBlock.run()");
    }
}
