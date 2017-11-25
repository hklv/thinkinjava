package chapter18;

import java.io.*;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 18:52
 */
public class MyPrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream = new PrintStream(new FileOutputStream(new File("d:" + File.separator + "hello3.txt")));
        printStream.println(true);
        printStream.println("Rollen");
        String name = "Rollen";
        int age = 20;
        printStream.printf("姓名:%s,年龄:%d", name, age);
        printStream.close();

        OutputStream out = System.out;
        try {
            out.write("hello".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try{
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
