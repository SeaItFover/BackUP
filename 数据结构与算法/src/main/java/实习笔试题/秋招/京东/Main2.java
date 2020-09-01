package 实习笔试题.秋招.京东;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sca = new Scanner(System.in);
        int mm = sca.nextInt();
        int[][] arrInt = new int[mm][2 * mm - 1];
        for (int i = 0; i < mm; i++) {
            for (int j = mm - i - 1; j < mm + i; j++) {
                arrInt[i][j] = sca.nextInt();
            }
        }
        int[][] dp = new int[mm][2 * mm - 1];
        for (int i = 0; i < 2 * mm - 1; i++) {
            dp[mm - 1][i] = arrInt[mm -1 ][i];
        }
        int ret = 0;
        for (int i = mm - 2; i >= 0; i--) {
            for (int j = mm - i - 1; j < mm + i; j++) {
                dp[i][j] = Math.max(dp[i+1][j -1], Math.max(dp[i +1][j], dp[i+1][j+1])) + arrInt[i][j];
                ret = dp[i][j];
            }
        }
        System.out.println(ret);
    }
}
