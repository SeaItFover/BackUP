package leetcode;

public class 最长公共子串 {

    public static void main(String[] args) {

        String str = "bbbbbbbbbbbbbbbbbbbbbbbbbbbb";
        System.out.println(longest(str));
        System.out.println(longestPlain(str));
        System.out.println(str.substring(0, 2));
    }

    //中心扩展算法
    public static String longest(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++){
            int len1 = longestSub(s,i,i);
            int len2 = longestSub(s,i,i+1);
            int len = Math.max(len1,len2);
            if ( len > end - start  ){
                start = i - (len - 1) / 2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }

    private static int longestSub(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j-i-1;
    }

    //时间复杂度过高
    public static String longestPlain(String str) {
        if (str.length() == 0 || str == null) {
            return "";
        }
        if (str.length() == 1) {
            return str;
        }
        int l = 0;
        int r = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            for (int j = i; j < str.length(); j++) {
                if (isHuiwen(str.substring(i, j + 1))) {
                    if ((r - l) < (j - i)) {
                        l = i;
                        r = j;
                    }
                }
            }
        }
        return str.substring(l, r + 1);
    }

    private static boolean isHuiwen(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) == str.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
