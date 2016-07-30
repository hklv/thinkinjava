import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/30
 */
public class Restaurant {
    Meal meal;
    Chef chef = new Chef(this);
    WaitPerson wait = new WaitPerson(this);
    protected ExecutorService exec = Executors.newCachedThreadPool();

    public Restaurant() {
        exec.execute(chef);
        exec.execute(wait);
    }

    public static void main(String[] args) {
        new Restaurant();
    }

}
