package leetcode.算法思想.窗口问题;

import java.util.LinkedList;

/**
 * 找到所有子数组中最大值减去最小值小于等于num的所有子数组数量
 */
public class AllLessNumSubArray {

    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<>();
        LinkedList<Integer> qmax = new LinkedList<>();
        int start = 0;
        int end = 0;
        int res = 0;
        while (start < arr.length) {
            while (end < arr.length) {
                while (!qmax.isEmpty() && arr[qmin.peekLast()] >= arr[end]) {
                    qmin.pollLast();
                }
                qmin.addLast(end);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[end]) {
                    qmax.pollLast();
                }
                qmax.addLast(end);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    break;
                }
                end++;
            }
            if (qmin.peekFirst() == start) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == start) {
                qmax.pollFirst();
            }
            res += end - start;
            start++;
        }
        return res;
    }



    //暴力法：遍历所有子数组，找出所有解
    public static int getLessNum(int[] arr, int num) {
        int res = 0;
        for (int start = 0; start < arr.length; start++) {
            for (int end = start; end < arr.length; end++) {
                if (isValid(arr, start, end, num)) {
                    res++;
                }
            }
        }
        return res;
    }

    public static boolean isValid(int[] arr, int begin, int end, int num) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = begin; i <= end; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return max - min <= num;
    }
}
