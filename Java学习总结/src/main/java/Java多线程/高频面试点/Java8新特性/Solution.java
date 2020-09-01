package Java多线程.高频面试点.Java8新特性;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3){
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            int l = i + 1;
            int r = nums.length - 1;
            if (nums[i] > 0){
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            while(l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                }else if (sum > 0){
                    r--;
                }else {
                    l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}