package chapter21;

/**
 * 父类
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/19
 */
public class Parent {
    static String name = "hello";

    {
        System.out.println("parent block");
    }

    static {
        System.out.println("parent static block");
    }

    public Parent() {
        System.out.println("parent constructor");
    }
}
