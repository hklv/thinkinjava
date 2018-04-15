package bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: HuiKang Lv
 * @Description: BIO
 * @Date: create at 2018/4/14 17:24
 */
public class BIOServer {
    private ServerSocket serverSocket;

    public BIOServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("BIO服务已启动，监听端口：" + port);

    }

    //监听客户端请求
    public void listener() throws IOException {
        while (true) {
            Socket client = serverSocket.accept();
            InputStream inputStream = client.getInputStream();
            byte[] buff = new byte[1024];
            int length = inputStream.read(buff);
            if (length > 0) {
                String msg = new String(buff, 0, length);
                System.out.println("接收到客户端发来的消息:" + msg);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new BIOServer(8080).listener();
    }
}
