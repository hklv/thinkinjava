package chapter18;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 19:05
 */
public class SystemError {
    public static void main(String[] args) {
        File file = new File("d:" + File.separator + "hello5.txt");
        System.err.println("这些在控制台展示");
        try {
            System.setErr(new PrintStream(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.err.println("这些在文件中才能看到");
    }
}
