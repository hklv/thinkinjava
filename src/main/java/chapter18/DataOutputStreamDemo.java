package chapter18;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/24 19:26
 */
public class DataOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D:" + File.separator + "hello5.txt");
        char[] ch = {'A', 'B', 'C'};
        DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
        for (char c : ch) {
            out.writeChar(c);
        }
    }
}
