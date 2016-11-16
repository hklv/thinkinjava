package chapter11;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by hklv on 2016/11/15.
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> intSet = new HashSet<Integer>();
        for (int i = 0; i < 10000; i++) {
            intSet.add(rand.nextInt());
        }
        System.out.println(intSet);
    }
}
