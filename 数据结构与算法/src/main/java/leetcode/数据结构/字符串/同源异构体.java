package leetcode.数据结构.字符串;

/**
 * 判断一个字符串中是否包含同源异构
 * 判断两个字符串（虽然字母一样，但是排序不同）
 */
public class 同源异构体 {

    public static boolean isTY(String str, String aim) {
        if (str.length() != aim.length()) {
            return false;
        }
        char[] strChar = str.toCharArray();
        char[] aimChar = aim.toCharArray();

        int[] count = new int[256];
        for (int i = 0; i < aim.length(); i++){
            count[aimChar[i]]++;
        }

        for (int i = 0; i < strChar.length; i++) {
            if (count[strChar[i]]-- == 0){
                return false;
            }
        }
        return true;
    }

    public static int containExactly3(String s, String a) {
        if (s == null || a == null || s.length() < a.length()) {
            return -1;
        }
        char[] aim = a.toCharArray();
        int[] count = new int[256];
        for (int i = 0; i < aim.length; i++) {
            count[aim[i]]++;
        }
        int M = aim.length;
        char[] str = s.toCharArray();
        int invalidTimes = 0;
        int R = 0;
        for (; R < M; R++){
            if (count[str[R]]-- <= 0){
                invalidTimes++;
            }
        }
        for (; R < str.length; R++){
            if (invalidTimes == 0){
                return R - M;
            }
            if (count[str[R]]-- <= 0){
                invalidTimes++;
            }
            if (count[str[R - M]]++ < 0){
                invalidTimes--;
            }
        }
        return invalidTimes == 0 ? R - M : -1;
    }
}
