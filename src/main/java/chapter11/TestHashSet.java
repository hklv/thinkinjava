package chapter11;

import java.util.HashSet;
import java.util.Set;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/12/21 14:29.
 */
public class TestHashSet {
    String size;
    String color;

    public TestHashSet(String size, String color) {
        this.size = size;
        this.color = color;
    }

    public boolean equals(Object object) {
        TestHashSet testHashSet = (TestHashSet) object;
        return this.size.equals(testHashSet.getSize()) && this.color.equals(testHashSet.getColor());
    }

    public int hashCode() {
        return size.hashCode() + color.hashCode();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "[Size=" + size + ",color=" + color;
    }


    public static void main(String[] args) {
        Set<TestHashSet> set = new HashSet<TestHashSet>();
        set.add(new TestHashSet("M", "red"));
        set.add(new TestHashSet("M", "red"));
        System.out.println(set);
    }
}
