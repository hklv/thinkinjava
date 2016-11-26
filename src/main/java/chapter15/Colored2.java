package chapter15;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/11/26 17:39.
 */
public class Colored2<T extends HasColor> extends HoldItem<T> {
    public Colored2(T item) {
        super(item);
    }

    java.awt.Color color() {
        return item.getColor();
    }
}
