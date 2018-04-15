package jvm_practice;

import java.util.Vector;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2018/1/9 10:20
 */
public class DumpOOM {
    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 0; i < 25; i++) {
            v.add(new byte[1 * 1024 * 1024]);
        }
    }
}
