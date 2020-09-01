package leetcode.数据结构.字符串.MANACHER;

public class Manacher {

    public static void main(String[] args) {
        Thread.currentThread().getName();

    }

    //public static String central()

    public static String getStr(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        return sb.toString();
    }
}
