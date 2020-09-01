package leetcode.数据结构.字符串.sunny;

/**
 * 实现strStr(函数。
 * 给定一个haystack字符串和一个needle字符串，
 * 在haystack字符串中找出needle字符串出现的第一个位置(从0开始)。如果不存在，则返回 -1。
 *
 * KMP  SUNDAY  RABIN_KARP
 */
public class StrStr {

    public static int strStrByRabinKarp(String str, String aim) {
        if (str == null || aim == null) {
            return -1;
        }
        if (str.length() < aim.length()) {
            return -1;
        }
        int hashS = 0;
        int hashA = 0;
        int r = 26;
        for (int i = 0; i < aim.length(); i++) {
            hashS = hashS * r + (str.charAt(i) - 'a');
            hashA = hashA * r + (aim.charAt(i) - 'a');
        }
        int i = 0;
        for (; i <= str.length() - aim.length(); i++) {
            if (hashS == hashA) {
                return i;
            }
            if (i + aim.length() == str.length()) {
                return -1;
            }
            hashS = (hashS - (str.charAt(i) - 'a') * r) * r + str.charAt(i + aim.length()) - 'a';
        }
        return i;
    }

    public static int strStrByKMP(String str, String aim){
        if (str == null || aim == null) {
            return -1;
        }
        if (str.length() < aim.length()) {
            return -1;
        }
        int[] next = getNextArray(str);
        int i = 0;
        int j = 0;
        while (i < str.length() && j < aim.length()) {
            if (str.charAt(i) == aim.charAt(j)) {
                i++;
                j++;
            }else if (next[j] == -1) {
                i++;
            }else {
                j = next[j];
            }
        }
        return j == aim.length() ? i - j : -1;
    }

    public static int[] getNextArray(String str) {
        if (str.length() == 1) {
            return new int[]{-1};
        }
        int[] arr = new int[str.length()];
        arr[0] = -1;
        arr[1] = 0;
        int cn = 0;
        for (int i = 2; i < str.length(); i++) {
            if (str.charAt(i - 1) == str.charAt(cn)) {
                arr[i++] = ++cn;
            }else if (cn > 0) {
                cn = arr[cn];
            }else {
                arr[i++] = 0;
            }
        }
        return arr;
    }

    public static int strStrBySunday(String origin, String aim) {
        if (origin == null || aim == null) {
            return -1;
        }
        if (origin.length() < aim.length()) {
            return -1;
        }
        int originIndex = 0;
        int aimIndex = 0;
        while (aimIndex < aim.length()){
            if (originIndex > origin.length() - 1){
                return -1;
            }
            if (origin.charAt(originIndex) == aim.charAt(aimIndex)){
                originIndex++;
                aimIndex++;
            }else {
                int nextIndex = originIndex - aimIndex + aim.length();
                if (nextIndex < origin.length()){
                    int step = aim.lastIndexOf(origin.charAt(nextIndex));
                    if (step == -1){
                        originIndex = nextIndex + 1;
                    }else {
                        originIndex = nextIndex - step;
                    }
                    aimIndex = 0;
                }else{
                    return -1;
                }
            }
        }
        return originIndex - aimIndex;
    }

    public static void main(String[] args) {
        String s = "abcdsfjkhgj";
        String aim = "gj";
        System.out.println(strStrBySunday(s,aim));
        System.out.println(strStrByKMP(s,aim));
        System.out.println(strStrByRabinKarp(s,aim));
    }
}
