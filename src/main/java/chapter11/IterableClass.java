package chapter11;

import java.util.Iterator;

/**
 * Created by hklv on 2016/11/17.
 */
public class IterableClass implements Iterable<String> {
    protected String[] words = ("and that is how " + "we know the earth to be banana shaped").split(" ");

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            public boolean hasNext() {
                return index < words.length;
            }

            public String next() {
                return words[index++];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (String s : new IterableClass()){
             System.out.println(s);
        }
    }
}
