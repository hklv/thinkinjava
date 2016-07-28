import java.util.concurrent.TimeUnit;

/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/28
 */
public class InterruptingIdiom {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Blocked3());
        t.start();
        TimeUnit.SECONDS.sleep(1);
        t.interrupt();
    }
}
