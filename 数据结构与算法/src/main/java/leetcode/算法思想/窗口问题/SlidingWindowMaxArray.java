package leetcode.算法思想.窗口问题;

import java.util.LinkedList;

/**
 * O(n)
 * 获取窗口内最大值，返回结果数组
 */
public class SlidingWindowMaxArray {

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || w < 1 || arr.length < w) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekFirst()] <= arr[i]) {
                qmax.pollFirst();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            if (i >= w -1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }
}
