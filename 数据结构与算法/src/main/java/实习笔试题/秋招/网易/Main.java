package 实习笔试题.秋招.网易;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        //System.out.println(Arrays.toString(arr));
        long res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                continue;
            }
            if (arr[i] == 2 || arr[i] == 3) {
                res++;
                continue;
            }
            res += arr[i] % 2 == 0 ? arr[i] / 2 : (arr[i] + 1) / 2  - 1;
        }
        System.out.println(res);
    }
}
