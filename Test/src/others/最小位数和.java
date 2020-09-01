package others;

import java.awt.*;
import java.util.Scanner;

public class 最小位数和 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        if (T<1 || T>10){
            return;
        }
        int[] arr = new int[T];
        for (int i = 0; i<T; i++){
            arr[i] = sc.nextInt();
        }
        for (int j = 0; j<T; j++){
            int m = arr[j] / 9;
            int n = arr[j] % 9;
            String ab = "";
            for(int ii = 0 ;ii < m; ii++){
                ab+="9";
            }
            System.out.println(Integer.valueOf(n+ab));
        }
    }
}
