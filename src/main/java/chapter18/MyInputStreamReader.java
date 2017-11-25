package chapter18;

import java.io.*;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/23 18:02
 */
public class MyInputStreamReader {
    public static void main(String[] args) throws IOException {
        String fileName = "d:" + File.separator + "hello2.txt";
        File file = new File(fileName);
        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("hello");
        writer.close();
        char[] c = new char[100];
        Reader reader = new InputStreamReader(new FileInputStream(file));
        int len = reader.read(c);
        System.out.println(new String(c, 0, len));
    }
}
