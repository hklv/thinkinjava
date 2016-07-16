/**
 * ResponsibleUI
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/16
 */
public class ResposibleUI extends Thread {
    private static volatile double d = 1;

    public ResposibleUI() {
        setDaemon(true);
        start();
    }

    public void run() {
        while (true) {
            d = d + (Math.PI + Math.E) / d;
        }
    }

    public static void main(String[] args) throws Exception {
//        new UnreposibleUI();
        new ResposibleUI();
        System.in.read();
        System.out.println();
    }


}
