package chapter21;

import java.util.concurrent.TimeUnit;

/**
 * Created by hklv on 2016/7/28.
 */
public class WaxOff implements Runnable {
    private Car car;

    public WaxOff(Car car) {
        this.car = car;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                car.waitingForWaxing();
                System.out.println("Wax off");
                TimeUnit.MILLISECONDS.sleep(100);
                car.buffered();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting via interrupt");
        }
        System.out.println("ending wax off task");
    }

}
