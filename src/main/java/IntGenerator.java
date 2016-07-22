/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/17
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;

    public abstract int next();

    public void cancel() {
        canceled = true;
    }

    public boolean isCanceled() {
        return canceled;
    }
}
