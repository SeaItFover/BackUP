package com.ilove.exception;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(out());
    }

    public static int out(){
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        String temp = s.nextLine();
        s.close();
        String[] st = temp.split(" ");
        if (st.length != n){
            return -1;
        }
        int[] arr = new int[st.length];
        for (int i = 0; i < st.length; i++){
            arr[i] = Integer.parseInt(st[i]);
        }

        int ret = 0;
        while (true){
            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
            if (arr[arr.length -1] < n){
                break;
            }else {
                arr[arr.length-1] -= n;
                for (int i = 0; i < arr.length -1; i++){
                    arr[i] += 1;
                }
                ret++;
            }
        }

        return ret;
    }
}
