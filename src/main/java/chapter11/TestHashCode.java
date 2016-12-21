package chapter11;

import java.util.HashMap;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/12/21 11:26.
 */
public class TestHashCode {

    private int id;
    private int age;
    private String name;

    public boolean equals(Object object) {
        TestHashCode hashCode = (TestHashCode) object;
        return hashCode.getAge() == this.getAge();
    }

  /*  public int hashCode(){
        return this.getId()*this.getAge();
    }*/

    public TestHashCode(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static void main(String[] args) {
        HashMap<TestHashCode,TestHashCode> map = new HashMap<TestHashCode,TestHashCode>();
        TestHashCode test1 = new TestHashCode(1, 18, "lhk");
        map.put(test1,test1);
        TestHashCode test2 = new TestHashCode(2, 18, "lhk1");
        map.put(test2,test1);
        System.out.println("isEquals :"+test1.equals(test2));
        System.out.println("test1:"+map.get(test1));
        System.out.println("test2:"+map.get(test2));
    }

    public int hashCode(){
        return this.getAge();
    }
}
