package chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/8/3.
 */
public class PrioritizedTask implements Runnable, Comparable<PrioritizedTask> {

    private Random rand = new Random(47);
    private static int counter = 0;
    private final int id = counter++;
    private final int priority;
    protected static List<PrioritizedTask> sequence = new ArrayList<PrioritizedTask>();

    public PrioritizedTask(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {

        }
    }

    public int compareTo(PrioritizedTask arg) {
        return priority > arg.priority ? 1 : (priority < arg.priority ? -1 : 0);
    }

    public String toString() {
        return String.format("[%1$-3d]", priority) + "chapter21.Task " + id;
    }

    public String summary() {
        return "(" + id + ":" + priority + ")";
    }

    public static class EndSentinel extends PrioritizedTask {
        private ExecutorService exec;

        public EndSentinel(ExecutorService exec) {
            super(-1);
            this.exec = exec;
        }

        public void run() {
            int count = 0;
            for (PrioritizedTask pt : sequence) {
                System.out.println(pt.summary());
                if (++count % 5 == 0) {
                    System.out.println();
                }
                System.out.println();
                System.out.println(this + " Calling shutdownNow()");
                exec.shutdownNow();
            }
        }
    }
}
