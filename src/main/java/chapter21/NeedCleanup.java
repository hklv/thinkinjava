package chapter21;

/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/28
 */
public class NeedCleanup {
    private final int id;

    public NeedCleanup(int id) {
        this.id = id;
    }

    public void cleanup() {
        System.out.println("cleaning up " + id);
    }
}
