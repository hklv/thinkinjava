package chapter18;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 18:31
 */
public class Receive implements Runnable {
    PipedInputStream in = null;

    public Receive() {
        this.in = new PipedInputStream();
    }

    public PipedInputStream getIn() {
        return in;
    }

    @Override
    public void run() {
        byte[] b = new byte[1024];
        int len = 0;
        try {
            len = in.read(b);

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(new String(b, 0, len));
    }
}
