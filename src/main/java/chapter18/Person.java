package chapter18;

import java.io.Serializable;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/27 10:29
 */
public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String toString() {
        return "姓名：" + name + " 年龄：" + age;
    }
}
