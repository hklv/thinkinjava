package chapter18;

import java.io.*;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-05-04 16:38.
 */
public class BasicFileOutput {
    static String file = "D:\\project\\thinkinJAVA\\thinkinjava\\src\\main\\java\\chapter18\\BasicFileOutput.out";

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new StringReader(BufferedInputFile.read("D:\\project\\thinkinJAVA\\thinkinjava\\src\\main\\java\\chapter18\\BasicFileOutput.java")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
        int lineCount = 1;
        String s;
        while ((s = in.readLine()) != null) {
            out.println(lineCount++ + ": " + s);
            //System.out.println(lineCount++ + ": " + s);
        }
        out.close();
        System.out.println(BufferedInputFile.read(file));
    }
}
