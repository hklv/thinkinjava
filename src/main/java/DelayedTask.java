import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * DelayedTask实例
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/8/3
 */
public class DelayedTask implements Runnable, Delayed {

    private static int counter = 0;
    private final int id = counter++;
    private final int delta;
    private final long trigger;
    protected static List<DelayedTask> sequence = new ArrayList<>();

    public DelayedTask(int delayInMilliseconds) {
        delta = delayInMilliseconds;
        trigger = System.nanoTime();
    }

    public void run() {
        System.out.println(this + " ");
    }

    public long getDelay(TimeUnit unit) {
        return unit.convert(trigger - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    public int compareTo(Delayed args) {
        DelayedTask that = (DelayedTask) args;
        if (trigger < that.trigger) return -1;
        if (trigger > that.trigger) return 1;
        return 0;
    }

    public String toString() {
        return String.format("[%1$-4d]", delta) + "Task" + id;
    }

    public String summary() {
        return "(" + id + ":" + delta + ")";
    }

    public static class EndSentinel extends DelayedTask {
        private ExecutorService exec;

        public EndSentinel(int delayInMilliseconds, ExecutorService exec) {
            super(delayInMilliseconds);
            this.exec = exec;
        }

        public void run() {
            for (DelayedTask pt : sequence) {
                System.out.println(pt.summary() + " ");
            }
            System.out.println();
            System.out.println(this + " Calling shutdownNow()");
            exec.shutdownNow();
        }
    }
}
