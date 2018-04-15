package jvm_practice;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2018/3/14 20:16
 */
public class Man {
    private int id = 1;
    Man() {
    }

    public People getWoman(final String name) {
        final int age = 1;
        class Woman extends People {
            public Woman() {
                System.out.println(age);
                System.out.println(name);
                System.out.println(id);
            }
        }
        return new Woman();
    }

    public static void main(String[] args){
        Man man = new Man();
        man.getWoman("ll");
    }

}
