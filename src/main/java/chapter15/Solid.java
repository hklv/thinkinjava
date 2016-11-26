package chapter15;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/11/26 17:22.
 */
public class Solid<T extends Dimension & HasColor & Weight> {
    T item;

    Solid(T item) {
        this.item = item;
    }

    java.awt.Color color() {
        return item.getColor();
    }

    int getX() {
        return item.x;
    }

    int getY() {
        return item.y;
    }

    int getZ() {
        return item.z;
    }

    int getWeight() {
        return item.weight();
    }
}
