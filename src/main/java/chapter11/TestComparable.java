package chapter11;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/12/22 9:47.
 */
public class TestComparable implements Comparable {
    private int age;
    private String name;

    public TestComparable(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Object o) {
        TestComparable obj = (TestComparable) o;
        if (this.age > obj.age) return 1;
        else if (this.age < obj.age) return -1;
        else return 0;
    }

    public String toString() {
        return "age:" + this.age + ",name:" + this.name;
    }
}
