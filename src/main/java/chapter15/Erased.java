package chapter15;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/11/24 17:58.
 */
public class Erased<T> {
    private final int SIZE = 100;

    public static void f(Object object) {
       // if (object instanceof T) {}
            //T var = new T();
            //T[] array = new T[SIZE];
           // T[] array = (T)new Object[SIZE];

    }
}
