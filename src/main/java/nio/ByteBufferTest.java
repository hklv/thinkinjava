package nio;

import java.nio.CharBuffer;


/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2018/4/3 9:49
 */
public class ByteBufferTest {
    private static int index = 0;

    private static String[] strings = {"A Random string value", "the product of an infinite number of monkeys", "Hey we are monkees", "Help Me, Help Me"};

    public static void main(String[] args) {
        CharBuffer buffer = CharBuffer.allocate(100);
        while (fillBuffer(buffer)) {
            buffer.flip();
            drainBuffer(buffer);
            buffer.clear();
        }
    }

    public static void drainBuffer(CharBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.println(buffer.get());
        }
        System.out.println("");
    }

    private static boolean fillBuffer(CharBuffer buffer) {
        if (index >= strings.length) {
            return false;
        }

        String string = strings[index++];
        for (int i = 0; i < string.length(); i++) {
            buffer.put(string.charAt(i));
        }
        return true;
    }


}
