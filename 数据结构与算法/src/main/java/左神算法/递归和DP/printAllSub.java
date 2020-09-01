package 左神算法.递归和DP;

/**
 * 打印字符串中所有子序列
 */
public class printAllSub {
    public static void main(String[] args) {
        String str = "fds";
        printAllSub(str.toCharArray(), 0, "");
    }

    public static void printAllSub(char[] str, int i, String res) {
        if (i == str.length) {
            System.out.println(res);
            return;
        }
        printAllSub(str, i + 1, res);
        printAllSub(str, i + 1, res + String.valueOf(str[i]));
    }
}
