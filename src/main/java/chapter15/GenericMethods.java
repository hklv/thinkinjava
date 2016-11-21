package chapter15;

/**
 * Created by hklv on 2016/11/19.
 */
public class GenericMethods {
    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public static void main(String[] args) {
        GenericMethods method = new GenericMethods();
        method.f("");
        method.f(1);
        method.f(1.0);
        method.f(1.0f);
        method.f('c');
        method.f(method);
    }
}
