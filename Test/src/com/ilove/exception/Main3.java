package com.ilove.exception;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] s = new String[n];
        for (int i = 0; i < n; i++){
            s[i] = sc.nextLine();
        }
        sc.close();
        MyComparator02 my = new MyComparator02();
        Arrays.sort(s,my);
        System.out.println(Arrays.toString(s));
    }
}

class MyComparator implements Comparator<String>{

    @Override
    public int compare(String o1, String o2) {
        return o1.charAt(o1.length()-1) - o2.charAt(o2.length()-1);
    }
}