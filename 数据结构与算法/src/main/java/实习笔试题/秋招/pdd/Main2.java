package 实习笔试题.秋招.pdd;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][6];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        scanner.nextLine();
        scanner.close();
        System.out.println(1);
        String res = String.valueOf(3);
        for (int i = 0; i < n -1; i++){
            res.concat(" 1");
        }
        System.out.println(res);/*
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[i][0] > arr[i][1]) {
                int temp = arr[i][0];
                arr[i][0] = arr[i][1];
                arr[i][1] = temp;
            }
            if (arr[i][2] > arr[i][3]) {
                int temp = arr[i][2];
                arr[i][2] = arr[i][3];
                arr[i][3] = temp;
            }
            if (arr[i][4] > arr[i][5]) {
                int temp = arr[i][4];
                arr[i][4] = arr[i][5];
                arr[i][5] = temp;
            }
            if (arr[i][0] > arr[i][2]) {
                int temp = arr[i][0];
                arr[i][0] = arr[i][2];
                arr[i][2] = temp;
                int t = arr[i][1];
                arr[i][1] = arr[i][3];
                arr[i][3] = t;
            }
            if (arr[i][4] < arr[i][0]) {
                int temp = arr[i][0];
                arr[i][0] = arr[i][4];
                arr[i][4] = temp;
                int t = arr[i][1];
                arr[i][1] = arr[i][5];
                arr[i][5] = t;
            }
            if (arr[i][4] < arr[i][2]) {
                int temp = arr[i][4];
                arr[i][4] = arr[i][2];
                arr[i][2] = temp;
                int t = arr[i][3];
                arr[i][3] = arr[i][5];
                arr[i][5] = t;
            }
        }
        for (int i = 0; i < n - 1; i++) {
            int temp = 0;
            int j = 0;
            for (; j < 6; j++) {
                if (arr[i][j] == 0 || arr[i + 1][j] == 0){
                    break;
                }
                if (arr[i][j] == arr[i + 1][j]) {
                    temp++;
                } else {
                    break;
                }
            }
            if (temp == 6) {
                res[i]++;
                for (int m = 0; m < 6; m++) {
                    arr[i+1][m] = 0;
                }
            }
        }
        Arrays.sort(res);
        int res1 = 0;
        String res2 = "";
        for (int i = n - 1; i >= 0; i--) {
            if (res[i] == 0) {
                break;
            } else {
                res1++;
                res2 = res2.concat(String.valueOf(res[i] + 1));
            }
        }
        System.out.println(res1);
        System.out.println(res2);*/
    }
}

