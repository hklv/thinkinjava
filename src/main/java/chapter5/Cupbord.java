package chapter5;

/**
 * Created by hklv on 2016/8/10.
 */
public class Cupbord {
    Bowl bowl3 = new Bowl(3);
    static Bowl bowl4 = new Bowl(4);

    Cupbord() {
        System.out.println("Cuppoard()");
        bowl4.f1(2);
    }

    void f3(int marker) {
        System.out.println("f3(" + marker + ")");
    }

    static Bowl bowl5 = new Bowl(5);
}
