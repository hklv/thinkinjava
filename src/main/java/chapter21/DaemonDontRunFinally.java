package chapter21;

/**
 * DaemonsDontRunFinally
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/14
 */
public class DaemonDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
       // t.setDaemon(true);
        t.start();
    }
}
