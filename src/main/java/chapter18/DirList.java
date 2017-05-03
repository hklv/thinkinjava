package chapter18;

import java.io.File;
import java.util.Arrays;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-04-28 9:41.
 */
public class DirList {
    public static void main(String[] args) {
        File path = new File(".");
        String[] list;
        if (args.length == 0) {
            list = path.list();
        } else {
            list = path.list(new DirFilter(args[0]));
        }
        assert list != null;
        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
        for (String dirItem : list) {
            System.out.println(dirItem);
        }
    }
}
