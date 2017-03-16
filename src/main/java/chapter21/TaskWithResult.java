package chapter21;

import java.util.concurrent.Callable;

/**
 * Created by hklv on 2016/7/13.
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }


    public String call() throws Exception {
        return "result of the chapter21.TaskWithResult " + id;
    }

}
