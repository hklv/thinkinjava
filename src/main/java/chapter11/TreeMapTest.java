package chapter11;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2017/1/7 16:06.
 */
public class TreeMapTest {

    public static void main(String[] args) {
        //Map<String, String> map = new TreeMap<String, String>();
        //Map<String, String> map = new TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
        /*Map<String, String> map = new TreeMap<String, String>(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });*/
        Map<String, String> map = new TreeMap<String, String>(Collections.reverseOrder());

        map.put("a", "abstract");
        map.put("c", "call");
        map.put("b", "basic");
        map.put("T", "tree");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        Map<String, Integer> map1 = new TreeMap<String, Integer>();
        map1.put("2016-7-3", 100);
        map1.put("2016-7-4", 120);
        map1.put("2016-8-1", 90);
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }

        Map<String, Integer> map2 = new TreeMap<String, Integer>(new Comparator<String>() {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            public int compare(String o1, String o2) {
                try {
                    return sdf.parse(o1).compareTo(sdf.parse(o2));
                } catch (ParseException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        });

        map2.put("2016-7-3", 100);
        map2.put("2016-7-4", 120);
        map2.put("2016-8-1", 90);
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println("Test Git Branch");
    }

}
