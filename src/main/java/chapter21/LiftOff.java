package chapter21;

/**
 * Created by hklv on 2016/7/10.
 */
public class LiftOff implements Runnable {

    protected int countDown = 10;
    private static int taskCount = 0;

    private final int id = taskCount++;

    public LiftOff() {
    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "chapter21.LiftOff!") + "),";
    }

    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            //Thread.yield();
        }
    }
}
