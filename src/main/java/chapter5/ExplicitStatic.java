package chapter5;

/**
 * Created by hklv on 2016/8/10.
 */
public class ExplicitStatic {
    public static void main(String[] args) {
        System.out.println("inside main");
        new Cups();
        System.out.println("new Cups() completed");
    }

    /*static Cups cups1 = new Cups();
    static Cups cups2 = new Cups();*/
}
