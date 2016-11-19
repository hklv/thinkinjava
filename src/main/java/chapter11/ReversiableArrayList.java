package chapter11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by hklv on 2016/11/18.
 */
public class ReversiableArrayList<T> extends ArrayList<T> {
    public ReversiableArrayList(Collection<T> collection) {
        super(collection);
    }

    public Iterable<T> reverse() {
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new Iterator<T>() {
                    int current = size() - 1;

                    public boolean hasNext() {
                        return current > -1;
                    }

                    public T next() {
                        return get(current--);
                    }

                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };
            }
        };
    }
}
