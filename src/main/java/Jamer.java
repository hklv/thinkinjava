/**
 * Created by hklv on 2016/8/1.
 */
public class Jamer implements Runnable {
    private ToastQueue buttererQueue, finishedQueue;

    public Jamer(ToastQueue butter, ToastQueue finishedQueue) {
        this.buttererQueue = butter;
        this.finishedQueue = finishedQueue;
    }

    public void run() {

        while (!Thread.interrupted()) {
            try {
                Toast t = buttererQueue.take();
                t.jam();
                System.out.println(t);
                finishedQueue.put(t);
            } catch (InterruptedException e) {

                System.out.println("Jammer Interrupt");
            }
            System.out.println("Jammer off");
        }
    }
}
