package chapter15;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by hklv on 2016/11/19.
 */
public class RandomList<T> {
    private ArrayList<T> storage = new ArrayList<T>();

    private Random rand = new Random(47);

    public void add(T item) {
        this.storage.add(item);
    }

    public T select() {
        return storage.get(rand.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        RandomList<String> randomList = new RandomList<String>();
        for (String s : ("the quick brown fox jumped over " + "the lazy brown dog").split(" ")) {
            randomList.add(s);
        }

        for (int i = 0; i < 11; i++) {
            System.out.println(randomList.select());
        }
    }
}
