package leetcode.算法思想.动态规划.背包问题;

import java.util.Arrays;

public class backpack01 {

    public static void main(String[] args) {
        System.out.println(backPack(10, new int[]{3, 4, 6, 8, 5}));
    }

    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public static int backPack(int m, int[] A) {
        int[][] dp = new int[A.length + 1][m + 1];
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= m; j++) {
                if (j < A[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    System.out.println(i+""+j);
                    print(dp);
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i-1]] + A[i-1]);
                }
            }


        }return dp[A.length][m];
    }
    private static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}