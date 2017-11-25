package chapter18;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 18:08
 */
public class Send implements Runnable {
    private PipedOutputStream out = null;

    public Send() {
        out = new PipedOutputStream();
    }

    public PipedOutputStream getOut() {
        return this.out;
    }


    @Override
    public void run() {
        String message = "Hello World";
        try {
            out.write(message.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
