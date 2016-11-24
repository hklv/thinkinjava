package chapter15;


/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/11/23 23:21.
 */
public class SimpleHolder {
    private Object obj;

    public void set(Object object) {
        this.obj = object;
    }

    public Object get() {
        return obj;
    }

    public static void main(String[] args) {
        SimpleHolder holder = new SimpleHolder();
        holder.set("Item");
        String s = (String) holder.get();
    }

}

