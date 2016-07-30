/**
 * @author lv huikang (mailto:lv.huikang@zte.com.cn))
 * @since 2016/7/30
 */
public class Meal {
    private final int orderNum;

    public Meal(int orderNum) {
        this.orderNum = orderNum;
    }

    public String toString() {
        return "Meal " + orderNum;
    }
}
