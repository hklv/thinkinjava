import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/8/3.
 */
public class HorseRace {
    private final int FINISH_LINE = 75;

    private List<Horse> horseList = new ArrayList<Horse>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;

    public HorseRace(final int nHorse, final int pause) {
        barrier = new CyclicBarrier(nHorse, new Runnable() {
            public void run() {
                StringBuilder s = new StringBuilder();
                for (int i = 0; i < nHorse; i++) {
                    s.append("=");
                }
                System.out.println(s);
                for (Horse horse : horseList) {
                    System.out.println(horse.tracks());
                }

                for (Horse horse : horseList) {
                    if (horse.getStrides() >= FINISH_LINE) {
                        System.out.println(horse + "won");
                        exec.shutdownNow();
                        return;
                    }
                }

                try {
                    TimeUnit.MILLISECONDS.sleep(pause);
                } catch (InterruptedException e) {
                    System.out.println("barrier -action sleep interrupted");
                }
            }
        });
        for (int i = 0; i < nHorse; i++) {
            Horse horse = new Horse(barrier);
            horseList.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorse = 7;
        int pause = 200;
        new HorseRace(nHorse, pause);
    }
}
