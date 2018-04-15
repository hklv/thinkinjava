package bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author: HuiKang Lv
 * @Description: cleint
 * @Date: create at 2018/4/14 17:30
 */
public class BIOClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 8080);
        OutputStream outputStream = client.getOutputStream();
        outputStream.write("报个到".getBytes());
        outputStream.close();
        client.close();
    }
}
