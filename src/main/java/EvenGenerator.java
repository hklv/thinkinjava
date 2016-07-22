/**
 * EvenGenerator
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/18
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;
        Thread.yield();
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new EvenGenerator());
    }
}
