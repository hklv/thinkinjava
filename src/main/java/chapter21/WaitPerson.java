package chapter21;

/**
 * 服务员
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/30
 */
public class WaitPerson implements Runnable {
    private Restaurant restaurant;

    public WaitPerson(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (this) {
                    while (restaurant.meal == null) {
                        wait();
                    }
                }
                System.out.println("chapter21.WaitPerson get " + restaurant.meal);
                synchronized (restaurant.chef) {
                    restaurant.meal = null;
                    restaurant.chef.notifyAll();
                }
            }
        } catch (InterruptedException e) {
            System.out.println("chapter21.WaitPerson interrupt");
        }

    }
}
