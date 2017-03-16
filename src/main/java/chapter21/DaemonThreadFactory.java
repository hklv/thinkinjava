package chapter21;

import java.util.concurrent.ThreadFactory;

/**
 * 后台线程工厂类
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/14
 */
public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
