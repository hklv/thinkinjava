package chapter21;

/**
 * Created by hklv on 2016/7/15.
 */
public class ThreadOperation {
    public static void main(String[] args) {
        new InnerThread("InnerThread1");
        new InnerThread2("chapter21.InnerThread2");
        new InnerRunnable("chapter21.InnerRunnable");
        new InnerRunnable2("chapter21.InnerRunnable2");
        new ThreadMethod("chapter21.ThreadMethod").runTask();
    }
}
