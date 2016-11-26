package chapter15;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/11/24 19:39.
 */
public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<Employee>(Employee.class);
        System.out.println("ClassAsFactory<Employee> succeed");
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<Integer>(Integer.class);
        } catch (Exception e) {
            System.out.println("ClassAsFactory<Integer> failed");
        }
    }
}
