package chapter21;

import java.util.concurrent.Callable;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/28 10:44
 */
public class TaskWithResult1 implements Callable<String> {
    private int id;

    public TaskWithResult1(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult1 " + id;
    }
}
