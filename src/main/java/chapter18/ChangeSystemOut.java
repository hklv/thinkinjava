package chapter18;

import java.io.PrintWriter;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-05-05 10:35.
 */
public class ChangeSystemOut {
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("Hello  World");
    }
}
