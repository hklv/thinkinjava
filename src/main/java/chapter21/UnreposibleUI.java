package chapter21;

import java.io.IOException;

/**
 * UnResposibleUI
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/16
 */
public class UnreposibleUI {
    private volatile double d = 1;

    public UnreposibleUI() throws IOException {
        while (d > 0) {
            d = d + (Math.PI + Math.E) / d;
        }
        System.in.read();
    }
}
