package chapter18;

import java.io.*;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/18 10:41
 */
public class BufferedInputFile1 {
    public static void read(String fileName, String filwName1) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        BufferedWriter out = new BufferedWriter(new FileWriter(filwName1));
        String s;
        while ((s = in.readLine()) != null) {
            out.write(s + "\n");

        }
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        read("D:\\project\\thinkinJAVA\\thinkinjava\\src\\main\\java\\chapter18\\BufferedInputFile1.java", "D:\\BufferedInputFile2.java");
    }
}
