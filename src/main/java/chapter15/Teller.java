package chapter15;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/11/23 11:06.
 */
public class Teller {
    private static long counter = 1;

    private final long id = counter++;

    public String toString() {
        return "Teller " + id;
    }

    public static Generator<Teller> generator() {
        return new Generator<Teller>() {
            public Teller next() {
                return new Teller();
            }
        };
    }
}
