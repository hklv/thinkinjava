package chapter18;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: HuiKang Lv
 * @Description: 测试文件类
 * @Date: create at 2017/10/30 14:44
 */
public class FileTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:/hello/hello.txt");
        /*OutputStream out = new FileOutputStream(file, true);
        *//*out.write("Hello World".getBytes());
        out.close();*//*
        String str = "Hello World";
        for (int i = 0; i < str.getBytes().length; i++) {
            out.write(str.getBytes()[i]);
        }
        out.close();*/
        FileInputStream in = new FileInputStream(file);
        byte[] b = new byte[(int) file.length()];
       /* in.read();
        in.close();
        System.out.println(new String(b));*/
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) in.read();
        }
        in.close();
        System.out.println(new String(b));

        InputStream in1 = new FileInputStream(file);
        byte[] b1 = new byte[1024];
        int temp;
        int len = 0;
        while ((temp = in1.read()) != -1) {
            b1[len] = (byte) temp;
            len++;
        }
        in1.close();
        System.out.println(new String(b1, 0, len));
    }
}
