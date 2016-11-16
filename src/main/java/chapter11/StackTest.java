package chapter11;

/**
 * Created by hklv on 2016/11/15.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        for (String temp : "this is a dog".split(" ")) {
            stack.push(temp);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
