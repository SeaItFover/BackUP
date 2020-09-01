package leetcode.算法思想.双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int min = nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3];
            if (min > target) {
                break;
            }
            int max = nums[n - 1] + nums[n - 2] + nums[n - 3] + nums[n - 4];
            if (max < target) {
                continue;
            }
            for (int j = i + 1; j < n - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int k = j + 1;
                int m = n - 1;
                int min2 = nums[i] + nums[j] + nums[j + 1] + nums[j + 2];
                if (min2 > target) {
                    break;
                }
                int max2 = nums[i] + nums[j] + nums[n - 1] + nums[n - 2];
                if (max2 < target) {
                    continue;
                }
                while (k < m) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[m];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[m]));
                        k++;
                        while (k < m && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        m--;
                        while (k < m && nums[m] == nums[m + 1]) {
                            m--;
                        }
                    }else if (sum > target) {
                        m--;
                    }else {
                        k++;
                    }
                }
            }
        }

        return res;
    }

}
