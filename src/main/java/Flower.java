/**
 * Created by hklv on 2016/8/9.
 */
public class Flower {
    int petalCount = 0;
    String s = "initial value";

    Flower(int petalCount) {
        this.petalCount = petalCount;
        System.out.println("Constructor int arg only,petalCount = " + petalCount);
    }

    Flower(String ss) {
        System.out.println("Constructor String arg only , s= " + ss);
        s = ss;
    }

    Flower(String s, int petals) {
        this(petals);
        this.s = s;
        System.out.println("string & int args");
    }

    Flower() {
        this("hi", 47);
        System.out.println("default constructor (no args)");
    }

    void printPetalCount() {
        System.out.println("petalCount = " + petalCount + " s = " + s);
    }

    public static void main(String[] args) {
        Flower flower = new Flower();
        flower.printPetalCount();
    }
}
