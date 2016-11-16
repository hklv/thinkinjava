package chapter11;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by hklv on 2016/11/15.
 */
public class ListFeature {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        Collections.shuffle(list);
        System.out.println(list);
    }
}
