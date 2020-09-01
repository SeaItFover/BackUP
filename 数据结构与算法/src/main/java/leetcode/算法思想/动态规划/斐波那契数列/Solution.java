package leetcode.算法思想.动态规划.斐波那契数列;

import java.util.Arrays;
import java.util.List;

class Solution {

    List<Character> vowels = Arrays.asList('a','e','i','o','u');

    public String reverseVowels(String s) {

        char[] arr = new char[s.length()];
        int i = 0;
        int j = s.length()-1;
        while (i < j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if (!vowels.contains(ci)){
                arr[i++] = ci;
            }else if(!vowels.contains(cj)){
                arr[j++] = cj;
            }else {
                arr[j++] = ci;
                arr[i++] = cj;
            }
        }
        return new String(arr);
    }
}
