package chapter21;

/**
 * chapter21.DaemonSpawn
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/14
 */
public class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}
