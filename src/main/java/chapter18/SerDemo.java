package chapter18;

import java.io.*;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/27 11:14
 */
public class SerDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person[] persons = {new Person("Jerry", 23), new Person("Kit", 32)};
        ser(persons);
        Object[] objs = der();
        for (Object o : objs) {
            System.out.println((Person) o);
        }
    }

    public static void ser(Object[] obj) throws IOException {
        File file = new File("D:" + File.separator + "hello.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(obj);
        out.close();
    }

    public static Object[] der() throws IOException, ClassNotFoundException {
        File file = new File("d:" + File.separator + "hello.txt");
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Object[] objs = (Object[]) in.readObject();
        in.close();
        return objs;
    }
}
