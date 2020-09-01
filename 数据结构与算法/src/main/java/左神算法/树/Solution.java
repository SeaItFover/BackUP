package 左神算法.树;

import java.util.Arrays;

class Solution {
    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int res = 0;
        int n = coins.length;

        for (int i = n - 1; i >= 0 && amount > 0; i--) {
            if (amount > coins[i]) {
                res += amount / coins[i];
                amount -= amount % coins[i];
            } else if (amount == coins[i]){
                return res + 1;
            }
        }

        if (amount != 0) {
            return -1;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{1, 20, 5};
        int amount = 11;
        System.out.println(coinChange(coins, amount));
    }
}