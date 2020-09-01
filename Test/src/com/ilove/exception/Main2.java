package com.ilove.exception;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        in.close();
        int ret = 0;
        for (int i = 1; i < n; i++){
            for (int j = i + 1; j <= n; j++){
                int temp = out1(i,j) - out2(i,j);

                if (temp > ret){
                    ret = temp;
                }
            }
        }
        System.out.println(ret);
    }

    public static int out1(int i, int j){
        return i * j / out2(i,j);
    }

    public static int out2(int m, int n){
        int num = 1;
        for (int i = 1; i <= m && i <= n; i++){
            if (m % i == 0 && i == 0){
                num = i;
            }
        }
        return num;
    }
}
