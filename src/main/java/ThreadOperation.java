/**
 * Created by hklv on 2016/7/15.
 */
public class ThreadOperation {
    public static void main(String[] args) {
        new InnerThread("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable("InnerRunnable");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}
