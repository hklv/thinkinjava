package chapter15;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/11/23 19:21.
 */
public class GenericBase<T> {
    private T element;

    public void set(T t) {
        element = t;
    }

    public T get() {
        return element;
    }
}
