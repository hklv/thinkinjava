package chapter18;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/23 18:15
 */
public class MyByteArrayInputStream {
    public static void main(String[] args) throws IOException {
        String str = "Jackson";
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        int temp = 0;
        while ((temp = in.read()) != -1) {
            char ch = (char) temp;
            out.write(Character.toUpperCase(ch));
        }
        String outStr = out.toString();
        in.close();
        out.close();
        System.out.println(outStr);
    }
}
