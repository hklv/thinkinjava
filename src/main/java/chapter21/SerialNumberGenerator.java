package chapter21;

/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/22
 */
public class SerialNumberGenerator {
    private static volatile int serialNumber = 0;

    public static int nextSerialNumber() {
        return serialNumber++;
    }
}
