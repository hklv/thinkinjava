package chapter5;

/**
 * Created by hklv on 2016/8/10.
 */
public class Cups {
    static Cup cup1;
    static Cup cup2;
    Cup cup3;
    Cup cup4;

    {
        cup3 = new Cup(3);
        cup4 = new Cup(4);
        System.out.println("cup3&cup4 initialized");
    }

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
        System.out.println("cup1&cup2 initialized");
    }


    Cups() {
        System.out.println("Cups");
    }


}
