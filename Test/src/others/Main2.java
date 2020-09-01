package others;

import java.util.ArrayList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        String[] s11 = s1.split(" ");
        String[] s22 = s2.split(" ");
        int n = Integer.parseInt(s11[0]);
        long m = Integer.parseInt(s11[1]);

        if (n != s22.length){
            System.out.println(0);
        }
        long[] arr = new long[n];
        for (int i = 0; i < n; i++){
            arr[i] = Long.parseLong(s22[i]);
        }
        int res = 0;
        for (int i = 0; i < n; i++){
            long sum = 0;
            for (int j = i; j < n; j++){
                sum += arr[j];
                if (sum % m == 0){
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
