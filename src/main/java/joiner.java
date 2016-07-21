/**
 * Created by hklv on 2016/7/15.
 */
public class Joiner extends Thread {
    private Sleeper sleeper;

    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }

    public void run() {
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("interrupter");
        }
        System.out.println(getName() + " join completed ");
    }
}
