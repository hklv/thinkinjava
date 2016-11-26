package chapter15;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/11/26 17:37.
 */
public class HoldItem<T> {
    T item;

    HoldItem(T item) {
        this.item = item;
    }

    T getItem() {
        return item;
    }
}
