package leetcode.数据结构.字符串;

/**
 * 完整的可以匹配任意字符集的算法
 * 方法也是计算出一个hash值，只不过
 * 要解决的问题是溢出
 * 解决方案：取模
 * 但是随之而来的问题是hash冲突。解决方案：如果pt相同，再做一次确认。
 */
public class Rabin_Karp {

    public static void main(String[] args) {
        System.out.println(rabinKarp("ab0?afb", "f"));
    }

    public static int rabinKarp(String t, String p) {
        int nt = t.length();
        int np = p.length();
        int pVal = 0;
        int tVal = 0;
        int h = 1;
        int r = 256;
        for (int i = 0; i < np - 1; i++) {
            h = (h * r) % 101;
        }
        for (int i = 0; i < np; i++) {
            pVal = (pVal * r + p.charAt(i)) % 101;
            tVal = (tVal * r + t.charAt(i)) % 101;
        }
        for (int i = 0; i <= nt - np; i++) {
            if (pVal == tVal) {
                int j = 0;
                for (; j < np; j++) {
                    if (t.charAt(i + j) != p.charAt(j)) {
                        break;
                    }
                }
                if (j == np) {
                    return i;
                }
            }
            if (i == nt - np) {
                return -1;
            }
            tVal = ((tVal - t.charAt(i) * h) * r + t.charAt(i + np)) % 101;
            if (tVal < 0) {
                tVal += 101;
            }
        }
        return -1;
    }
}
