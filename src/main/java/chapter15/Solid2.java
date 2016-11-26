package chapter15;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/11/26 17:47.
 */
public class Solid2<T extends Dimension & HasColor & Weight> extends ColoredDimension<T> {

    public Solid2(T item) {
        super(item);
    }

    int weight() {
        return item.weight();
    }

}
