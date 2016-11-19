package chapter11;

import java.util.*;

/**
 * Created by hklv on 2016/11/16.
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
        Random random = new Random(47);
        for (int i = 0; i < 600; i++) {
            priorityQueue.offer(random.nextInt());
        }

        QueueDemo.printQ(priorityQueue);
        List<Integer> inst = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 23, 25);
        priorityQueue = new PriorityQueue<Integer>(inst);
        QueueDemo.printQ(priorityQueue);
        priorityQueue = new PriorityQueue<Integer>(inst.size(), Collections.reverseOrder());
        priorityQueue.addAll(inst);
        QueueDemo.printQ(priorityQueue);
        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(" "));
        PriorityQueue<String> stringQ = new PriorityQueue<String>(strings);
        QueueDemo.printQ(stringQ);
        stringQ = new PriorityQueue<String>(strings.size(), Collections.reverseOrder());

        stringQ.addAll(strings);
        Set<Character> charSet = new HashSet<Character>();
        for (Character character : fact.toCharArray()) {
            charSet.add(character);
        }
        PriorityQueue<Character> charQueue = new PriorityQueue<Character>(charSet);
        QueueDemo.printQ(charQueue);
    }
}
