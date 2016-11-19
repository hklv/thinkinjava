package chapter11;

import java.util.*;

/**
 * Created by hklv on 2016/11/18.
 */
public class ModifyingArraysAsList {
    public static void main(String[] args) {
        Random random = new Random(47);
        Integer[] in = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> list1 = new ArrayList<Integer>(Arrays.asList(in));

        System.out.println("Before Shuffling " + list1);
        Collections.shuffle(list1);
        System.out.println("After Shuffling " + list1);
        System.out.println("Array :" + Arrays.toString(in));

        List<Integer> list2 = Arrays.asList(in);
        System.out.println("Before Shuffling " + list2);
        Collections.shuffle(list2);
        System.out.println("After Shuffling " + list2);
        System.out.println("Array :" + Arrays.toString(in));

    }
}
