package chapter18;

import java.io.*;

/**
 * @Author: HuiKang Lv
 * @Description: 字符流
 * @Date: create at 2017/10/31 10:09
 */
public class WriterReaderTest {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/hello/test.txt");
        Writer writer = new FileWriter(file, true);
        String hello = "Hello World";
        writer.write(hello);
        writer.close();
        Reader reader = new FileReader(file);
        char[] c = new char[1024];
        int len = reader.read(c);
        reader.close();
        System.out.println(new String(c, 0, len));
        Reader reader1 = new FileReader(file);
        char[] c1 = new char[1024];
        int temp = 0;
        int len1 = 0;
        while ((temp = reader1.read()) != -1) {
            c1[len1] = (char) temp;
            len1++;
        }
        reader1.close();
        System.out.println(new String(c, 0, len1));
    }
}
