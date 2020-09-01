package 实习笔试题.秋招.pdd;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();
        int dis = k;
        int back = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > dis) {
                dis -= 2 * dis - arr[i];
                back++;
            } else if (arr[i] < dis) {
                dis -= arr[i];
            } else {
                System.out.println("paradox");
                return;
            }
        }
        System.out.println(String.valueOf(dis).concat(" ").concat(String.valueOf(back)));
    }
}
