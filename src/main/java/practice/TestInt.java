package practice;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2018/3/14 12:20
 */
public class TestInt {
    public static void main(String[] args) {
        Integer i = 100;
        Integer j = 100;
        System.out.println(i == j);
        Integer a = new Integer(100);
        Integer b = new Integer(100);
        int c = 100;
        System.out.println(a == b);
        System.out.println(i == a);
        System.out.println(a == c);
        Integer d = 128;
        Integer e = 128;
        System.out.println(d == e);

    }
}
