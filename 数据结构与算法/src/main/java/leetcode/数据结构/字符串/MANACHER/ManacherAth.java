package leetcode.数据结构.字符串.MANACHER;

import java.util.Arrays;

public class ManacherAth {

    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i =  0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' :charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];
        int C = -1;
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i != charArr.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                C = i;
                R = i + pArr[i];
            }
            max = Math.max(max,pArr[i]);
        }
        System.out.println(Arrays.toString(pArr));
        return max - 1;
    }

    public static void main(String[] args) {
        String str1 = "absffsba";
        System.out.println(maxLcpsLength(str1));
    }
}
