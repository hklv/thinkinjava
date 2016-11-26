package chapter15;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/11/26 17:49.
 */
public class InheritBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<Bounded>(new Bounded());
        solid.color();
        solid.getY();
        solid.getWeight();
    }
}
