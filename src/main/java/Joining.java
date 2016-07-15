/**
 * Created by hklv on 2016/7/15.
 */
public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("sleepy", 1500);
        Sleeper groov = new Sleeper("groov", 1500);
        Joiner doper = new Joiner("Doeper", sleepy);
        Joiner doc = new Joiner("Doc", groov);
        groov.interrupt();
    }
}
