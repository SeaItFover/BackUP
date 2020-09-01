package others;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String[] s11 = s1.split(" ");
        int n = Integer.parseInt(s11[0]);
        int k = Integer.parseInt(s11[1]);
        String s2 = scanner.nextLine();
        char[] arr = s2.toCharArray();
        Arrays.sort(arr);
        int res = Integer.MAX_VALUE;
        int pos = -1;
        for (int i = 0; i < n; i++){
            int temp = 0;
            for (int j = 0; j < k; j++){
                temp += Math.abs(arr[i] - arr[j]);
            }
            if (res > temp){
                res = temp;
                pos = i;
            }
        }
        System.out.println(res);
    }
}
