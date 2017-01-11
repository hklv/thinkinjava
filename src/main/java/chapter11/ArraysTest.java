package chapter11;

import java.util.Arrays;

/**
 * @author LvHuiKang mailTo lv.huikang@zte.com.cn.
 * @Date 2016/12/21 15:53.
 */
public class ArraysTest {
    public static void main(String[] args) {
        String[] strArr = {"hello", "world"};
        System.out.println(Arrays.toString(strArr));
        int[] intArr = {9, 8, 7};
        System.out.println(Arrays.toString(intArr));

        System.out.println(strArr.toString());

        int[] arr = {4, 9, 3, 6, 10};
        Arrays.sort(arr, 0, 3);
        System.out.println(Arrays.toString(arr));

        TestComparable[] test = {new TestComparable(18, "jack"), new TestComparable(20, "David"), new TestComparable(13, "Tom")};
        Arrays.sort(test);
        System.out.println(Arrays.toString(test));
    }
}
