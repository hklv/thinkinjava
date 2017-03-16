package chapter21;

/**
 * chapter21.SelfManaged
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/15
 */
public class SelfManaged implements Runnable {
    private int countDown = 5;
    private Thread t = new Thread(this);

    public SelfManaged() {
        t.start();
    }

    public String toString() {
        return Thread.currentThread().getName() + "(" + countDown + ")";
    }

    @Override
    public void run() {

        while (true) {
            System.out.println(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
