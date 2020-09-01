package leetcode.数据结构.字符串.BFPRT.topN;

import java.util.Arrays;

/**
 * O(nlogn)
 */
public class TopNByHeap {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 32, 4, 1, 45,};
        System.out.println(Arrays.toString(getMaxK(arr, 5)));
    }

    public static int[] getMaxK(int[] arr, int k) {
        if (k < 1 || k > arr.length) {
            return arr;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(kHeap, arr[i], i);
        }
        System.out.println(Arrays.toString(kHeap));
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > kHeap[0]) {
                kHeap[0] = arr[i];
                heapify(kHeap, 0, k);
            }
        }
        return kHeap;
    }

    public static void heapInsert(int[] heap, int value, int i) {
        heap[i] = value;
        while (i != 0) {
            int parent = (i - 1) / 2;
            if (heap[i] < heap[parent]) {
                swap(heap, i, parent);
                i = parent;
            }else {
                break;
            }
        }
    }

    public static void heapify(int[] heap, int index, int length) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int min = index;
        while (left < length) {
            if (heap[left] < heap[min]) {
                min = left;
            }
            if (right < length && heap[right] < heap[min]) {
                min = right;
            }
            if (min != index) {
                swap(heap, min, index);
            }else {
                break;
            }
            index = min;
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
