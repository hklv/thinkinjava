package chapter18;

import java.io.*;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/27 10:41
 */
public class ExternalizableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ser();
        der();
    }

    public static void ser() throws IOException {
        File file = new File("d:" + File.separator + "hello.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(new Person("Rollen", 12));
        out.close();
    }

    public static void der() throws IOException, ClassNotFoundException {
        File file = new File("d:" + File.separator + "hello.txt");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Object object = in.readObject();
        in.close();
        System.out.println(object);
    }
}
