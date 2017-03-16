package chapter21;

/**
 * Created by hklv on 2016/8/1.
 */
public class Eater implements Runnable {
    private ToastQueue finishedQueue;
    private int counter = 0;

    public Eater(ToastQueue t) {
        finishedQueue = t;
    }

    public void run() {

        try {
            while (!Thread.interrupted()) {
                Toast t = finishedQueue.take();
                if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED) {
                    System.out.println(">>>>>>>>Error: " + t);
                    System.exit(1);
                } else {
                    System.out.println("Chomp!" + t);
                }
            }
        } catch (InterruptedException e) {
            System.out.println("chapter21.Eater interrupted");
        }
        System.out.println("chapter21.Eater off");
    }
}
