package chapter21;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/8/1.
 */
public class Philosopher implements Runnable {
    private Chopsticks left;
    private Chopsticks right;
    private final int id;
    private final int ponderFactor;
    private Random random = new Random(47);

    private void pause() throws InterruptedException {
        if (ponderFactor == 0) {
            return;
        }
        TimeUnit.MILLISECONDS.sleep(random.nextInt(ponderFactor * 250));
    }

    public Philosopher(Chopsticks left, Chopsticks right, int iden, int ponder) {
        this.left = left;
        this.right = right;
        this.id = iden;
        this.ponderFactor = ponder;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println(this + " " + "thinking");
                pause();
                System.out.println(this + "  " + "grabbing right");
                right.take();
                System.out.println(this + " " + "grabbing left");
                left.take();
                System.out.println(this + " " + "eating");
                pause();
                right.drop();
                left.drop();
            }
        } catch (InterruptedException e) {
            System.out.println(this + "Exiting via interrupt");
        }
    }

    public String toString() {
        return "philosopher " + id;
    }
}
