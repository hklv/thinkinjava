package chapter18;

import java.io.*;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 19:38
 */
public class SequenceInputStreamDemo {
    public static void main(String[] args) throws IOException {
        File file1 = new File("d:" + File.separator + "hello1.txt");
        File file2 = new File("d:" + File.separator + "hello2.txt");
        File file3 = new File("d:" + File.separator + "hello3.txt");

        InputStream in1 = new FileInputStream(file1);
        InputStream in2 = new FileInputStream(file2);
        OutputStream out = new FileOutputStream(file3);
        SequenceInputStream sequenceInputStream = new SequenceInputStream(in1, in2);
        int temp = 0;
        while ((temp = sequenceInputStream.read()) != -1) {
            out.write(temp);
        }
        out.close();
        in1.close();
        in2.close();
        sequenceInputStream.close();
    }
}
