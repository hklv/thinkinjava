package jvm_practice;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2018/3/14 20:27
 */
public class Outter {
    int a = 1;
    static int b = 2;

    public Outter() {
    }

    static class Inner {
        public Inner(){
           // System.out.println(a);
            System.out.println(b);
        }
    }
}
