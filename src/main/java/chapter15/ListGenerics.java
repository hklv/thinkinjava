package chapter15;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/11/24 20:13.
 */
public class ListGenerics<T> {
    private List<T> array = new ArrayList<T>();

    public void set(T item) {
        array.add(item);
    }

    public T get(int index) {
        return array.get(index);
    }
}
