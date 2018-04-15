package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: HuiKang Lv
 * @Description:
 * @Date: create at 2018/3/20 21:32
 */
public class Client {
    public static void main(String[] args) {
        /*System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring("amqpcsrumjjufpu"));*/
      //  System.out.println(lengthOfLongestSubstring("nfbmpabaprknhchdzzax"));
       /* int[] a1 = {1,3};
        int[] a2 = {2};
        System.out.println(findMedianSortedArrays(a1,a2));
        System.out.println('c'=='s');
        StringBuffer s = new StringBuffer();
        s.append("".charAt(0));
        "abcd".charAt(0);*/
        System.out.println(Integer.valueOf("-123"));
        System.out.println(String.valueOf(-123));
        //boolean i = "".charAt(0) == 'c';
        StringBuffer sb = new StringBuffer();
       // System.out.println(Integer.valueOf("9646324351"));
        System.out.println(Math.pow(2,32));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(String.valueOf(Integer.MAX_VALUE));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        String startChar = String.valueOf(s.charAt(0));
        StringBuffer longestChar = new StringBuffer(startChar);
        int beginIndex = 0;
        for (int i = 1; i <= s.length() - 1; i++) {
            if (longestChar.toString().contains(String.valueOf(s.charAt(i)))) {
                beginIndex = beginIndex + longestChar.toString().indexOf(s.charAt(i)) + 1;
                continue;
            }
            if (longestChar.length() > s.length()-beginIndex) {
                break;
            }
            if (s.substring(beginIndex, i + 1).length() < longestChar.toString().length()) {
                continue;
            }

            longestChar = new StringBuffer(s.substring(beginIndex, i + 1));
        }
        return longestChar.toString().length();
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list1 = new ArrayList();
        for(int i=0;i<nums1.length;i++){
            list1.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            list1.add(nums2[i]);
        }
        Collections.sort(list1);
        if(list1.size()%2==0){
            return (list1.get(list1.size()%2)+list1.get(list1.size()%2-1))/2.0;
        }else{
            return list1.get(list1.size()/2);
        }
    }
}
