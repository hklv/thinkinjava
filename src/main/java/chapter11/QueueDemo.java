package chapter11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by hklv on 2016/11/16.
 */
public class QueueDemo {
    public static void printQ(Queue queue) {
        while (queue.peek() != null) {
            System.out.println(queue.remove() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(i + 10));
        }
        printQ(queue);
        Queue<Character> qc = new LinkedList<Character>();
        for (char c : "BRON".toCharArray()) {
            qc.add(c);
        }
        printQ(qc);
    }
}
