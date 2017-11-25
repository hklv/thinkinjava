package chapter18;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 19:29
 */
public class DataInputStreamDemo {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream(new File("d:" + File.separator + "hello5.txt")));
        char[] ch = new char[10];
        int count = 0;
        char temp;
        while ((temp = in.readChar()) != 'C') {
            ch[count++] = temp;
        }
        System.out.println(ch);
    }
}
