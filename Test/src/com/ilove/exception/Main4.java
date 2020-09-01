package com.ilove.exception;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;

public class Main4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String mn = sc.nextLine();
        String[] mnt = mn.split(" ");
        int m = Integer.parseInt(mnt[0]);
        int n = Integer.parseInt(mnt[1]);
        String[] s = new String[n];
        for (int i = 0; i < n; i++){
            s[i] = sc.nextLine();
        }
        MyComparator02 myComparator02 = new MyComparator02();

        Arrays.sort(s, myComparator02);
        for (int i = 0; i < n; i++){
            System.out.println(s[i]);
        }
    }
}

class MyComparator02 implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return du(o1) - du(o2);
    }

    public int du(String str){
        int ret = 0;
        for (int i = 0; i < str.length(); i++){
            for (int j = i + 1; j < str.length(); j++){
                if (str.charAt(i) > str.charAt(j)){
                    ret++;
                }
            }
        }
        return ret;
    }
}