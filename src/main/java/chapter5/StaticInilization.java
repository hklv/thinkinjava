package chapter5;

/**
 * Created by hklv on 2016/8/10.
 */
public class StaticInilization {
    public static void main(String[] args) {
        System.out.println("creating new cuppoard in main");
        new Cupbord();
        System.out.println("creating new cuppoard in main");
        new Cupbord();
        table.f2(1);
        cupbord.f3(1);
    }

    static Table table = new Table();
    static Cupbord cupbord = new Cupbord();
}
