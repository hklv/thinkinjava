package chapter18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-05-05 10:31.
 */
public class Echo {
    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = stdin.readLine()) != null && s.length() != 0) {
            System.out.println(s);
        }
    }
}
