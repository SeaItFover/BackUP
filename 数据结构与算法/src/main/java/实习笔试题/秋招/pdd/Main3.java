package 实习笔试题.秋招.pdd;

import java.util.Scanner;

public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int t = scanner.nextInt();
        /*if (t <= 0) {
            System.out.println(0);
            return;
        } else {
            System.out.println(-1);
            return;
        }*/
        int res = 0;
        int[][] mid = new int[n][2];
        int[][] dinner = new int[m][2];
        for (int i = 0; i < n; i++) {
            mid[i][0] = scanner.nextInt();
            mid[i][1] = scanner.nextInt();
            if (mid[i][1] >= t) {
                res = mid[i][0];
            }
        }
        for (int i = 0; i < m; i++) {
            dinner[i][0] = scanner.nextInt();
            dinner[i][1] = scanner.nextInt();
            if (dinner[i][1] >= t) {
                res = dinner[i][0];
            }
        }
        scanner.close();
        System.out.println(res);
    }
}
