import java.util.concurrent.TimeUnit;

/**
 * Daemons
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/14
 */
public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Daemon());
        t.setDaemon(true);
        t.start();
        System.out.println("t.isDaemon()" + t.isDaemon() + "");
        TimeUnit.MICROSECONDS.sleep(1);
    }
}
