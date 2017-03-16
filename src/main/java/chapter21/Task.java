package chapter21;

/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/30
 */
public class Task implements Runnable {
    static Blocker blocker = new Blocker();

    @Override
    public void run() {
        blocker.waitingCall();
    }
}
