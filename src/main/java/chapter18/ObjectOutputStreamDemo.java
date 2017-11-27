package chapter18;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/27 10:31
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("d:" + File.separator + "hello.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(new Person("Tom", 12));
        oos.close();
    }
}
