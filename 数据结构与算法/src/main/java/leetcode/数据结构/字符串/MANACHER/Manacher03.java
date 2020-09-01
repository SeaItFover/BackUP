package leetcode.数据结构.字符串.MANACHER;

public class Manacher03 {

    public static void main(String[] args) {
        String s = "cabac";
        System.out.println(manacher(s));
    }

    public static int manacher(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }
        String str = getManaString(s);
        int[] pArr = new int[str.length()];
        int C = -1;
        int R = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < str.length(); i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < str.length() && i - pArr[i] >= 0) {
                if (str.charAt(i + pArr[i]) == str.charAt(i - pArr[i])){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static String getManaString(String s) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (char c : arr) {
            sb.append(c);
            sb.append("#");
        }
        return sb.toString();
    }
}
