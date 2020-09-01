package 实习笔试题.秋招.美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!res.contains(arr[i][j])) {
                    res.add(arr[i][j]);
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(res.get(i));
            System.out.print(" ");
        }
    }
}
