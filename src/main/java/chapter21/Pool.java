package chapter21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by hklv on 2016/8/7.
 */
public class Pool<T> {
    private int size;
    private volatile boolean[] checkOut;
    private Semaphore available;
    private List<T> items = new ArrayList<T>();

    public Pool(Class<T> objectClass, int size) {
        this.size = size;
        checkOut = new boolean[size];
        for (int i = 0; i < size; i++) {
            try {
                items.add(objectClass.newInstance());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public T checkOut() throws InterruptedException {
        available.acquire();
        return getItem();
    }

    public synchronized T getItem() {
        for (int i = 0; i < size; i++) {
            if (!checkOut[i]) {
                checkOut[i] = true;
                return items.get(i);
            }
        }
        return null;
    }

    private synchronized boolean releaseItem(T item) {
        int index = items.indexOf(item);
        if (index == -1) {
            return false;

        }
        if (checkOut[index]) {
            checkOut[index] = false;
            return true;
        }
        return false;

    }

    public void checkIn(T x) {
        if (releaseItem(x)) {
            available.release();
        }
    }

}
