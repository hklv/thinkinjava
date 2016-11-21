package chapter15;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by hklv on 2016/11/19.
 */
public class Generators {
    public static <T> Collection<T> fill(Collection<T> coll, Generator<T> gen, int n) {
        for (int i = 0; i < n; i++) {
            coll.add(gen.next());
        }
        return coll;
    }

    public static void main(String[] args) {
        Collection<Coffee> cofeee = fill(new ArrayList<Coffee>(), new CoffeeGenerator(), 4);
        for (Coffee c : cofeee) {
            System.out.println(c);
        }
        Collection<Integer> fNumbers = fill(new ArrayList<Integer>(), new Fibonacci(), 12);
        for (Integer i : fNumbers) {
            System.out.println(i);
        }
    }
}
