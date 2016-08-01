import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/8/1.
 */
public class Toaster implements Runnable {
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(47);

    public Toaster(ToastQueue toastQueue) {
        this.toastQueue = toastQueue;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt());
            }
        } catch (InterruptedException e) {
        }
    }
}
