package chapter11;

import java.util.*;

/**
 * Created by hklv on 2016/11/15.
 */
public class addingGroups {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        Integer[] moreInts = {5, 6, 7, 8, 9};
        c.addAll(Arrays.asList(moreInts));
        Collections.addAll(c, 10, 11, 12, 13);
        Collections.addAll(c, moreInts);
        List<Integer> list = Arrays.asList(16, 17, 18, 19);
        list.set(1, 99);
        System.out.print(c);
        System.out.print(list);

        List<Integer> lis = Arrays.asList(1, 2, 3);
        lis.add(4);
        System.out.print(lis);
    }
}
