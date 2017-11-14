package socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/14 21:24
 */
public class Client {
    public static void main(String[] args) {
        String msg = "Client data";
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw.println(msg);
            pw.flush();
            String line = is.readLine();
            System.out.println("received from server: " + line);
            pw.close();
            is.close();
            socket.close();
        } catch (Exception e) {

        }
    }
}
