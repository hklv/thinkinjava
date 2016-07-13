/**
 * Created by hklv on 2016/7/11.
 */
public class BasicThreads {
    public static void main(String     [] args) {
        Thread thread = new Thread(new LiftOff());
        thread.start();
        System.out.println("waiting for LiftOff");
    }
}
