package leetcode;

import java.util.ArrayList;
import java.util.List;

public class 电话号码组合 {

    public static void main(String[] args) {

    }

    private List<String> res = new ArrayList<>();

    private String[] phone = {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0) {
            dfs("", digits);
        }
        return res;
    }

    private void dfs(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            res.add(combination);
        }else {
            String digit = next_digits.substring(0,1);
            String letters = phone[Integer.parseInt(digit)];
            for (int i = 0; i < letters.length(); i++) {
                dfs(combination + letters.charAt(i), next_digits.substring(1));
            }
        }
    }
}





