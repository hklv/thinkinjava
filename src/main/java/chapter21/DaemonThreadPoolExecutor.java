package chapter21;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * chapter21.DaemonThreadPoolExecutor
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/14
 */
public class DaemonThreadPoolExecutor extends ThreadPoolExecutor {
    public DaemonThreadPoolExecutor() {
        super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
    }
}
