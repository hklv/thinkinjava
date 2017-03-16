package chapter21;

/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/28
 */
public class Blocked2 implements Runnable {
    BlockedMutex blockedMutex = new BlockedMutex();

    @Override
    public void run() {
        System.out.println("waiting for f() in chapter21.BlockedMutex");
        blockedMutex.f();
        System.out.println("Broken out of blocked call");
    }
}
