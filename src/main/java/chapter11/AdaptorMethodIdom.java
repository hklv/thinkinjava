package chapter11;

import java.util.Arrays;

/**
 * Created by hklv on 2016/11/18.
 */
public class AdaptorMethodIdom {
    public static void main(String[] args) {
        ReversiableArrayList<String> rev = new ReversiableArrayList<String>(Arrays.asList("To be or not to be".split(" ")));
        for (String s : rev) {
            System.out.println(s);
        }

        for (String s : rev.reverse()) {
            System.out.println(s);
        }
    }
}
