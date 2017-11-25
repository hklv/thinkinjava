package chapter18;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 19:09
 */
public class SystemIn {
    public static void main(String[] args) {
        File file = new File("d:" + File.separator + "hello5.txt");
        if (!file.exists()) {
            return;
        } else {
            try {
                System.setIn(new FileInputStream(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            byte[] bytes = new byte[1024];
            int len = 0;
            try {
                len = System.in.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("读入的内容：" + new String(bytes, 0, len));
        }

    }
}
