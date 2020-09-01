package 剑指offer;

public class 十四丶剪绳子 {
    public static void main(String[] args) {
        System.out.println(integerBreak(2));
    }

    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                System.out.println(dp[i]);
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];
    }
}
