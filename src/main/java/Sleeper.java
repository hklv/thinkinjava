/**
 * Created by hklv on 2016/7/15.
 */
public class Sleeper extends Thread {
    private int duration;

    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }

    public void run() {
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            System.out.println(getName() + " was interrupted." + "isInterrupted:" + isInterrupted());
        }
        System.out.println(getName() + " has awakened");
    }

}
