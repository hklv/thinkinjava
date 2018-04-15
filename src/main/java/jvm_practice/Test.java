package jvm_practice;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2018/3/14 20:46
 */
public class Test extends Circle{

    public Test(double radius) {
        super(radius);
    }




    public static void test1(){
        test();
    }

    public static void main(String[] args){
        StringBuffer s = new StringBuffer("abdcabc");
        System.out.println(s.indexOf("d"));
    }
}
