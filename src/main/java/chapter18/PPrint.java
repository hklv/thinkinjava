package chapter18;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-04-28 10:32.
 */
public class PPrint {
    public static String pformat(Collection<?> files) {
        if (files.size() == 0) {
            return "[]";
        }
        StringBuilder result = new StringBuilder("[");
        for (Object elem : files) {
            if (files.size() != 1) {
                result.append("\n ");
            }
            result.append(elem);
        }
        if (files.size() != 1) {
            result.append("\n ");
        }
        result.append("]");
        return result.toString();
    }

    public static void ppprint(Collection<?> c) {
        System.out.println(pformat(c));
    }

    public static void ppprint(Object[] c) {
        System.out.println(pformat(Arrays.asList(c)));
    }
}
