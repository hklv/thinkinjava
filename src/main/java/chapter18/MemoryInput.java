package chapter18;

import java.io.IOException;
import java.io.StringReader;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-05-04 15:33.
 */
public class MemoryInput {
    public static void main(String[] args) throws IOException {
        StringReader in = new StringReader(BufferedInputFile.read("D:\\project\\thinkinJAVA\\thinkinjava\\src\\main\\java\\chapter18\\MemoryInput.java"));
        int c;
        while((c=in.read())!=-1){
            System.out.print((char)c);
        }
    }
}
