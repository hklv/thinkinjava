package jvm_practice;

import java.lang.ref.WeakReference;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2018/1/9 22:13
 */
public class WeakRef {
    public static class User {
        public int id;
        public String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        User user = new User(1, "Jack");
        WeakReference weakReference = new WeakReference(user);
        user = null;
        System.out.println(weakReference.get());
        System.gc();
        System.out.println("After GC");
        System.out.println(weakReference.get());
    }
}
