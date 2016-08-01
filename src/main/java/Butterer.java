/**
 * Created by hklv on 2016/8/1.
 */
public class Butterer implements Runnable {
    private ToastQueue dryQueue, butterQueue;

    public Butterer(ToastQueue dry, ToastQueue butter) {
        dryQueue = dry;
        butterQueue = butter;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                Toast t = dryQueue.take();
                t.butter();
                System.out.println(t);
                butterQueue.put(t);

            }
        } catch (InterruptedException e) {
            System.out.println("Butterer Interrupt");
        }
        System.out.println("Butterer off");
    }
}
