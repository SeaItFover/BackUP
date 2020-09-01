package leetcode.算法思想.动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 生成有效括号 {

    public static void main(String[] args) {

    }
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();
        dp.add(Arrays.asList(""));
        if (n == 0) {
            return dp.get(n);
        }
        for (int i = 1; i < n; i++) {
            List<String> dpTemp = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = dp.get(j);
                List<String > str2 = dp.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        dpTemp.add("(" + s1 + ")" + s2);
                    }
                }
            }

            dp.add(dpTemp);
        }

        return dp.get(n);
    }

    //回溯法
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        int l = 0;
        int r = 0;
        dfs(res, "",  n, l, r);
        return res;
    }

    private void dfs(List<String> res, String path, int n, int l, int r) {
        if (r > l || l > n || r > n) {
            return;
        }
        if (l == n && r == n) {
            res.add(path);
            return;
        }
        dfs(res, path + "(" , n, l + 1, r);
        dfs(res, path + ")", n, l, r + 1);
    }


}
