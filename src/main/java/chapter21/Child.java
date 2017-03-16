package chapter21;

/**
 * 子类
 *
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/19
 */
public class Child extends Parent {
    static String name = "hello";

    {
        System.out.println("child block");
    }

    static {
        System.out.println("child static block");
    }

    public Child() {
        System.out.println("chapter21.Child Constructor");
    }
}
