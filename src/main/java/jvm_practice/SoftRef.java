package jvm_practice;

import java.lang.ref.SoftReference;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2018/1/9 21:43
 */
public class SoftRef {
    public static class User {
        public int id;
        public String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "id: " + id + ",name: " + name;
        }

    }

    public static void main(String[] args) {
        User user = new User(1, "Tom");
        SoftReference<User> userSoftReference = new SoftReference<User>(user);
        user = null;
        System.out.println(userSoftReference.get());
        System.gc();
        System.out.println("After GC");
        System.out.println(userSoftReference.get());
        byte[] b = new byte[1024 * 900 * 7];
        System.gc();
        System.out.println(userSoftReference.get());
    }
}
