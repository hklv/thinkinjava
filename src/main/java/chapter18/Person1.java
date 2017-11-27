package chapter18;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2017/11/27 10:45
 */
public class Person1 implements Externalizable {
    private String name;
    private int age;

    public Person1() {
    }

    public Person1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "姓名：" + name + " 年龄：" + age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(this.name);
        out.writeInt(this.age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name = (String) in.readObject();
        this.age = in.readInt();
    }
}
