package chapter21;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/28 10:47
 */
public class CallableDemo1 {
    public static void main(String[] args) throws ExecutionException {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<Future<String>>();
        for (int i = 0; i < 10; i++) {
            results.add(exec.submit(new TaskWithResult1(i)));
        }
        for (Future<String> f : results) {
            try {
                System.out.println(f.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                exec.shutdown();
            }
        }
    }
}
