package chapter18;

import java.io.*;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-05-04 16:33.
 */
public class TestEOF {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("D:\\project\\thinkinJAVA\\thinkinjava\\src\\main\\java\\chapter18\\TestEOF.java")));
        while (in.available()!=0){
            System.out.print((char)in.readByte());
        }
    }
}
