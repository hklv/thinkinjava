package chapter15;

import java.util.*;

/**
 * Created by hklv on 2016/11/19.
 */
public class New {
    public static <K, V> Map<K, V> map() {
        return new HashMap<K, V>();
    }

    public static <T> List<T> list() {
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> lList() {
        return new LinkedList<T>();
    }

    public static <T> Set<T> set() {
        return new HashSet<T>();
    }

    public static <T> Queue<T> queue() {
        return new LinkedList<T>();
    }

    public static void main(String[] args) {
        Map<String, List<String>> map = New.map();
        List<String> ls = New.list();
        LinkedList<String> lls = New.lList();
        Queue<String> qs = New.queue();
    }
}
