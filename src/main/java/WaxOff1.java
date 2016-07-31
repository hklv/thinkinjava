import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/7/31.
 */
public class WaxOff1 implements Runnable {
    private Car car;

    public WaxOff1(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitingForWaxing();
                System.out.println("Wax off!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffered();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
    }
}
