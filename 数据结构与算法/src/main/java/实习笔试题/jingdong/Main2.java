package 实习笔试题.jingdong;

import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int ret;
        int n = in.nextInt();
        int[][] taur = new int[n][2];
        for (int i = 0; i < n; i++) {
            taur[i][0] = in.nextInt();
            taur[i][1] = in.nextInt();
        }

        System.out.println(n/2 + 1);
        ret = ttttt(taur, n);
        System.out.println(ret);
    }

    private static int ttttt(int[][] ui, int n) {
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret = Math.max(ret, uuuuu(ui, i, 0, n));
            ret = Math.max(ret, uuuuu(ui, i, 1, n));
        }
        return ret;
    }

    private static int uuuuu(int[][] it, int pot, int j, int n) {
        int ret = 1;
        int target = it[pot][j];
        for (int i = 0; i < n; i++) {
            if (pot == 1) continue;
            if (target >= it[i][0] && target <= it[i][1]) {
                ret++;
            }
        }
        return ret;
    }


}

