package chapter15;

import java.util.Iterator;

/**
 * Created by hklv on 2016/11/19.
 */
public class IterableFabonacci extends Fibonacci implements Iterable<Integer> {
    private int n;

    public IterableFabonacci(int count) {
        this.n = count;
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            public boolean hasNext() {
                return n > 0;
            }

            public Integer next() {
                n--;
                return IterableFabonacci.this.next();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (int i : new IterableFabonacci(18)) {
            System.out.println(i + " ");
        }
    }
}
