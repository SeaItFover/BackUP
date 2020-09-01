package IO和NIO.IO;

import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        System.out.println(permute());
    }

    public static String permute(){
        Scanner s = new Scanner(System.in);
        int[] arr = new int[9];
        String temp = s.nextLine();
        s.close();
        String[] tt = temp.split(",");
        for (int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(tt[i]);
        }
        int a = 0;
        for (int i = 0; i < 9; i++){
            a = arr[i] ^ (i + 1) ^ a;
        }
        if (a != 0){
            return "no";
        }
        int b = arr[0] + arr[1] + arr[2] + arr[3];
        int c = arr[3] + arr[4] + arr[5] + arr[6];
        int d = arr[7] + arr[8] + arr[0] + arr[6];
        if (b == c && c == d){
            return "yes";
        }
        return "no";
    }
}
