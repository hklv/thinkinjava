package chapter18;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/27 10:37
 */
public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("d:" + File.separator + "hello.txt");
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file));
        Object object = inputStream.readObject();
        inputStream.close();
        System.out.println(object);
    }
}
