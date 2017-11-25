package chapter18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 19:01
 */
public class SystemDemo {
    public static void main(String[] args) {
        System.out.println("hello");
        File file = new File("D:" + File.separator + "hello4.txt");
        try {
            System.setOut(new PrintStream(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("这些内容在文件中才能看到");
    }
}
