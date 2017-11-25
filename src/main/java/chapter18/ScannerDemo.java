package chapter18;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 19:23
 */
public class ScannerDemo {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("d:" + File.separator + "hello.txt");
        Scanner scanner = new Scanner(file);
        String str = scanner.next();
        System.out.println("从文件中读取的内容是：" + str);
    }
}
