package 实习笔试题.jingdong;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static List<String> can() {
        Scanner sc = new Scanner(System.in);
        List<String> res = new ArrayList<>();
        int n = sc.nextInt();
        int[][] arr = new int[n][12];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < 12; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        int[] hash = new int[10000];
        for (int i = 0; i < n; i++){
            Arrays.fill(hash,0);
            for (int j = 0; j < 12; j++){
                hash[arr[i][j]]++;
            }
            int k = 0;
            for (; k < hash.length; k++){
                if (hash[k] != 0 && hash[k] != 4 && hash[k] != 12 && hash[k] != 8){
                    res.add("IMPOSSIBLE");
                    break;
                }
            }
            if (k >= hash.length){

                for (int m = 0; m < n; m++){
                    if (res.size() > m && res.get(m) != "IMPOSSIBLE"){
                        int y = 0;
                        for (int t = 0; t < 6; t++){
                            for (int u = t+1; u < 6; u++){
                                if (arr[m][2*t] != 0 && arr[m][2*u] != 0 && (arr[m][2*t] ^ arr[m][2*t+1] ^ arr[m][2*u] ^ arr[m][2*u+1]) == 0){
                                    arr[m][2*t] = 0;
                                    arr[m][2*t+1] = 0;
                                    arr[m][2*u] = 0;
                                    arr[m][2*u+1] = 0;
                                    break;
                                }
                            }
                        }

                        for (; y < 12; y++){
                            if (arr[m][y] != 0){
                                res.add("IMPOSSIBLE");
                                break;
                            }
                        }
                        if (y >= 12){
                            res.add("POSSIBLE");
                        }
                    }

                }
            }
        }
        return res;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        List<String> res = can();
        for (int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}

