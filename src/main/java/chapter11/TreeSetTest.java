package chapter11;

import java.util.Arrays;
import java.util.Set;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2017/1/11 17:36.
 */
public class TreeSetTest {
    public static void main(String[] args) {
        Set<String> words = new java.util.TreeSet<String>();
        words.addAll(Arrays.asList(new String[]{"tree", "map", "hash", "map"}));
        for (String w : words) {
            System.out.println(w + " ");
        }
    }
}
