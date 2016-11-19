package chapter11;

import java.util.*;

/**
 * Created by hklv on 2016/11/18.
 */
public class MultiIterableClass extends IterableClass {

    public Iterable<String> reversed() {
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    int current = words.length - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }

                    public String next() {
                        return words[current--];
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }


    public Iterable<String> randomized() {
        return new Iterable<String>() {
            public Iterator<String> iterator() {
                List<String> shuffled = new ArrayList<String>(Arrays.asList(words));
                Collections.shuffle(shuffled, new Random(47));
                return shuffled.iterator();
            }
        };
    }

    public static void main(String[] args) {
        MultiIterableClass mu = new MultiIterableClass();
        for (String s : mu.reversed()) {
            System.out.println(s + " ");
        }
        System.out.println();
        for (String s : mu.randomized()) {
            System.out.println(s + " ");
        }
        System.out.println();
        for (String s : mu) {
            System.out.println(s + " ");
        }
    }
}
