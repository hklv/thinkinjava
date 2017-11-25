package chapter18;

import java.io.IOException;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 18:50
 */
public class Client {
    public static void main(String[] args) {
        Send send = new Send();
        Receive receive = new Receive();
        try {
            send.getOut().connect(receive.getIn());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(send).start();
        new Thread(receive).start();
    }
}
