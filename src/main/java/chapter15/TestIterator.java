package chapter15;

import java.util.Iterator;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/12/20 15:48.
 */
public class TestIterator implements Iterable {

    public Iterator iterator(){
        return new Iterator() {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                return null;
            }

            public void remove() {

            }
        };
    }
}
