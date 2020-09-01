package leetcode.数据结构.字符串.KMP;

public class TestKMP {
    public static void main(String[] args) {

    }

    public static int getIndex(String s, String m) {
        int i1 = 0;
        int i2 = 0;
        int[] next = getNextArray(m);
        while (i1 < s.length() && i2 < m.length()) {
            if (s.charAt(i1) == m.charAt(i2)) {
                i1++;
                i2++;
            }else if (next[i2] == -1) {
                i1++;
            }else {
                i2 = next[i2];
            }
        }
        return i2 == m.length() ? i1 - i2 : -1;
    }

    public static int[] getNextArray(String str2) {
        //如何提取前提条件
        char[] chars = str2.toCharArray();
        int[] next = new int[str2.length()];

        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        int i = 2;
        while (i < str2.length()) {
            if (chars[i - 1] == chars[cn]) {
                next[i++] = ++cn;
            }else if (cn > 0) {
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }
}

