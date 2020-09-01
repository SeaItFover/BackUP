package leetcode.数据结构.字符串;

/**
 * 缺陷：只能应用在只含数字的情况
 * 当目标字符串长度太大的时候，会导致数据溢出。
 */
public class Test_Rabin_Karp {

    public static void main(String[] args) {
        System.out.println(rabinKarp("314152888","415"));
    }

    public static int rabinKarp(String t, String p) {
        int nt = t.length();
        int np = p.length();
        int tVal = 0;
        int pVal = 0;
        int h = (int)Math.pow(10, np - 1);
        int r = 10;
        //
        for (int i = 0; i < np; i++) {
            pVal = pVal * r + (p.charAt(i) - '0');
            tVal = tVal * r + (t.charAt(i) - '0');
        }
        for (int i = 0; i <= nt - np; i++) {
            if (pVal == tVal) {
                return i;
            }else if (i + np < nt){
                tVal = (tVal - (t.charAt(i) - '0') * h) * r + (t.charAt(i + np) - '0');
            }
        }
        return -1;
    }
}
