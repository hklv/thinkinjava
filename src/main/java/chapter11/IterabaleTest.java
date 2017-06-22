package chapter11;

import java.util.Iterator;

/**
 * @author LvHuiKang mailTo lv.huikang@ztesoft.com
 * @Date 2017-06-13 16:46.
 */
public class IterabaleTest implements Iterable<String> {
    protected String words[] = {"I Love You Baby"};

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public Object next() {
                return words[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        for (String s : new IterabaleTest()) {
             System.out.println(s+" ");
        }
    }
}
