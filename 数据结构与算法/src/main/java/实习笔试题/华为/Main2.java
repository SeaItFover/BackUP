package 实习笔试题.华为;

import java.util.Arrays;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class Main2 {
    public static void main(String[] args) {
        System.out.println(res());
    }

    public static String res(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        sc.nextLine();
        int[][] arr2 = new int[n][];
        for (int i = 0; i < n; i++){
            String[] st = sc.nextLine().split(" ");
            if (st.length < 2){
                return "NA";
            }
            int[] temp = new int[st.length];
            for (int j = 0; j < st.length; j++){
                temp[j] = Integer.parseInt(st[j]);
            }
            arr2[i] = temp;
        }
        for (int i = 0; i < arr2.length; i++){
            System.out.println(Arrays.toString(arr2[i]));
        }
        int res = 0;
        int sum = 0;
        for (int i = 2; i < arr2[0].length; i++){
            res = Math.max(res,arr2[0][1] + smbb(arr2,arr2[0][i] - 1));
        }
        return String.valueOf(res);
    }

    public static int smbb(int[][] arr,int i){

        if ( arr[i].length == 2){
            return arr[i][1];
        }

        return arr[i][1] + smbb(arr,arr[i][2]-1);
    }
}
