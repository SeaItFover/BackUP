package Java集合类.concurrenthashashmap;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 1; j <= n; j++){
            dp[0][j] = dp[0][j-1] + 1;
        }
        for (int i = 1; i <= m; i++){
            dp[i][0] = dp[i-1][0] + 1;
        }
        print(dp);
        System.out.println();
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]) + 1;
                }
                print(dp);
                System.out.println();
            }
        }
        return dp[m][n];
    }

    private static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++){
            System.out.println(Arrays.toString(dp[i]));

        }
    }
}
