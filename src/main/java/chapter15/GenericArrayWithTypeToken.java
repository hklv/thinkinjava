package chapter15;

import java.lang.reflect.Array;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/11/26 16:56.
 */
public class GenericArrayWithTypeToken<T> {
    private T[] array;

    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    public T get(int index) {
        return array[index];
    }

    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> genericArrayWithTypeToken = new GenericArrayWithTypeToken<Integer>(Integer.class, 10);

        Integer[] ia = genericArrayWithTypeToken.rep();
    }
}
