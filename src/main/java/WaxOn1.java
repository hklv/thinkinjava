import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/7/30.
 */
public class WaxOn1 implements Runnable {
    private Car car;

    public WaxOn1(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                System.out.println("WaxOn");
                TimeUnit.MILLISECONDS.sleep(100);
                car.waxed();
                car.waitingForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending wax on task");
    }
}
