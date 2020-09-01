package leetcode.数据结构.数组;

import java.util.Arrays;

public class 寻找两个有序数组的中位数 {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] res = merge(nums1, nums2);
        double ret = 0;
        if (res.length % 2 == 0) {
            ret = (double)(res[res.length / 2 - 1] + res[res.length / 2]) / 2;
        } else {
            ret = res[res.length / 2];
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {3, 4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int[] res = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        int indexR = 0;
        while (index1 < m && index2 < n) {
            if (arr1[index1] < arr2[index2]) {
                res[indexR++] = arr1[index1++];
            } else if (arr1[index1] > arr2[index2]) {
                res[indexR++] = arr2[index2++];
            } else {
                res[indexR++] = arr1[index1++];
                res[indexR++] = arr2[index2++];
            }
        }

        while (index2 < n) {
            res[indexR++] = arr2[index2++];
        }
        while (index1 < n) {
            res[indexR++] = arr2[index1++];
        }

        System.out.println(Arrays.toString(res));
        return res;
    }
}
