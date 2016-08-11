package chapter5;

import chapter5.access.Cookie;

/**
 * Created by hklv on 2016/8/11.
 */
public class ChocolateChip extends Cookie {
    public ChocolateChip() {
        System.out.println("ChocolateChop Constructor");
    }

    public void chomp() {
        //bite();
    }

    public static void main(String[] args) {
        ChocolateChip x = new ChocolateChip();
        x.chomp();
    }
}
