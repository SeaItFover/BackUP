package 剑指offer;

import java.util.LinkedList;

/**
 *
 */
public class 五丶替换字符串中的空格 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("I am a pig!");
        System.out.println(replaceSpace(sb));
    }

    public static String replaceSpace(StringBuffer stringBuffer) {
        int p1 = stringBuffer.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (stringBuffer.charAt(i) == ' ') {
                stringBuffer.append("  ");
            }
        }
        int p2 = stringBuffer.length() - 1;
        while (p1 >= 0 && p2 >= p1) {
            if (stringBuffer.charAt(p1) != ' ') {
                stringBuffer.setCharAt(p2, stringBuffer.charAt(p1));
                p1--;
                p2--;
            } else {
                p1--;
                stringBuffer.setCharAt(p2--, '0');
                stringBuffer.setCharAt(p2--, '2');
                stringBuffer.setCharAt(p2--, '%');
            }
        }

        return stringBuffer.toString();
    }
}
