package leetcode.数据结构.字符串.KMP;

public class KMP02 {
    public static int kmp(String s, String m) {
        if (s == null || m == null || s.length() == 0 || m.length() == 0 || s.length() < m.length()) {
            return -1;
        }
        int[] next = getNextArray(m);
        int indexS = 0;
        int indexM = 0;
        while (indexS < s.length() && indexM < m.length()) {
            if (s.charAt(indexS) == m.charAt(indexM)) {
                indexM++;
                indexS++;
            }else if (next[indexM] == -1) {
                indexS++;
            }else {
                indexM = next[indexM];
            }
        }
        return indexM == m.length() ? indexS - indexM : -1;
    }

    public static int[] getNextArray(String s) {
        if (s.length() == 1) {
            return new int[]{-1};
        }
        int[] next = new int[s.length()];
        next[0] = -1;
        next[1] = 0;
        int cn = 0;
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(cn)) {
                next[i++] = ++cn;
            }else if (cn > 0) {
                cn = next[cn];
            }else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "sdfadfas";
        String m = "as";
        System.out.println(kmp(s,m));
    }
}
