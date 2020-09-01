package 算法课程.数组中的问题最常见.滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 438给定一个字符串s，和一个字符串p，找出s中所有和p的字母异位，输入所有的下标
 */
public class 所有的字母异位串 {

    public static void main(String[] args) {
        //System.out.println('a'^'b');
        System.out.println(Arrays.toString(sea3("abab", "ab")));
    }

    public static Object[] sea(String s, String p) {
        if (s.length() < p.length()) {
            return null;
        }
        ArrayList<Integer> a = new ArrayList<>();
        int l = 0;
        int r = p.length() - 1;
        int tmp = 0;
        for (int i = 0; i<p.length(); i++){
            tmp = tmp ^ p.charAt(i);
        }

        while (r < s.length()) {
            int temp = tmp;
            for (int i = l; i <= r; i++) {
                temp = temp ^ s.charAt(i);
            }
            if (temp == 0){
                a.add(l);
            }
            l++;
            r++;
        }

        Object[] res = a.toArray();
        return res;

    }

    public static Object[] sea3(String s, String p) {
        if (s.length() < p.length()) {
            return null;
        }
        ArrayList<Integer> a = new ArrayList<>();
        int l = 0;
        int r = p.length() - 1;
        int tmp = 0;
        char[] arr = p.toCharArray();
        Arrays.sort(arr);

        while (r < s.length()) {
            int temp = tmp;
            char[] newArr = new char[p.length()];
            for (int i = l; i <= r; i++) {
                newArr[i-l] = s.charAt(i);
            }
            Arrays.sort(newArr);

            if (Arrays.equals(newArr,arr)){
                a.add(l);
            }
            l++;
            r++;
        }

        Object[] res = a.toArray();
        return res;

    }

}
