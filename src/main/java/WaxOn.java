import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/7/28.
 */
public class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("Wax on");
                TimeUnit.MILLISECONDS.sleep(100);
                car.waxed();
                car.waitingForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via Interrupting ");
        }
        System.out.println("Ending waxing task");
    }
}
