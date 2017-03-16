package chapter21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * chapter21.EvenChecker
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/18
 */
public class EvenChecker implements Runnable {
    private IntGenerator intGenerator;
    private final int id;

    public EvenChecker(IntGenerator g, int ident) {
        intGenerator = g;
        id = ident;
    }


    @Override
    public void run() {
        while (!intGenerator.isCanceled()) {
            int val = intGenerator.next();
            if (val % 2 != 0) {
                System.out.println(val + " not even");
                intGenerator.cancel();
            }
        }
    }

    public static void test(IntGenerator generator, int count) {
        System.out.println("Press Ctrl C exist");
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenChecker(generator, i));
        }
        exec.shutdown();
    }

    public static void test(IntGenerator generator) {
        test(generator, 10);
    }
}
