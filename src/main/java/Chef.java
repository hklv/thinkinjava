import java.util.concurrent.TimeUnit;

/**
 * 厨师
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/30
 */
public class Chef implements Runnable {
    private Restaurant restaurant;
    private int count = 0;

    public Chef(Restaurant r) {
        this.restaurant = r;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal != null) {
                        wait();
                    }
                }
                if (++count == 10) {
                    System.out.println("out of food closing");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("Order up");
                synchronized (restaurant.wait) {
                    restaurant.meal = new Meal(count);
                    restaurant.wait.notifyAll();
                }
                TimeUnit.MICROSECONDS.sleep(100);
            }
        } catch (InterruptedException e) {
            System.out.println("Chef interrupted");
        }
    }
}
