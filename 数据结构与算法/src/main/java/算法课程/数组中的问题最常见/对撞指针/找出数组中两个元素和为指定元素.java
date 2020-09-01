package 算法课程.数组中的问题最常见.对撞指针;

import java.util.Arrays;

/**
 * 167给定一个有序数组，给定一个target，找出数组中两个数和为target
 */
public class 找出数组中两个元素和为指定元素 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        //System.out.println(Arrays.toString(twoSum(arr, 9)));
        System.out.println(Arrays.toString(twoSum3(arr, 9)));
    }

    //暴力法：O(n^2)时间复杂度，遍历数组
    public static int[] twoSum(int[] arr, int target) {
        int[] ret; //new int[2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == target) {
//                    ret[0] = i + 1;
//                    ret[1] = j + 1;
                    ret = new int[]{i+1,j+1};
                    return ret;
                }
            }
        }
        return null;
    }

    /**
     * 类似于暴力法，但是我们在选择另一个元素的时候采用二分查找法
     * 时间复杂度：O(nlogn)
     */
    public static int[] twoSum2(int[] arr, int target) {
        int[] ret = new int[2];
        for (int i = 0; i < arr.length; i++) {
            int k = -1;
            if ((k = binartSearch(arr, i + 1, arr.length - 1, target - arr[i])) != -1) {
                ret[0] = i + 1;
                ret[1] = k + 1;
                return ret;
            }
        }
        return null;
    }

    private static int binartSearch(int[] arr, int l, int r, int target) {
        while (l <= r) {
            int mid = (l + r) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 利用对撞指针的方法求解
     * 时间复杂度：O(n)
     */
    public static int[] twoSum3(int[] arr, int target) {
        int[] ret = new int[2];
        int i = 0;
        int j = arr.length-1;
        while (i < j) {
            if ((arr[i] + arr[j]) == target) {
                ret[0] = i + 1;
                ret[1] = j + 1;
                return ret;
            } else if ((arr[i] + arr[j]) > target) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }
}
