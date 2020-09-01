package 实习笔试题.秋招.京东;

import java.util.Arrays;

public class Test {

    public static int[] topN(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return arr;
        }
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(heap, i, arr[i]);
        }
        for(int i = k; i < arr.length; i++) {
            if (arr[i] > heap[0]) {
                heap[0] = arr[i];
                heapify(heap, 0, k);
            }
        }
        return heap;
    }

    private static void heapify(int[] heap, int i, int k) {
        int left = 2 * i + 1;
        while (left < k) {
            int min = left + 1 < k && heap[left + 1] < heap[left] ?
                    left + 1 : left;
            min = heap[min] < heap[i] ? min : i;
            if (min == i) {
                break;
            }
            swap(heap, i, min);
            i = min;
            left = 2 * i + 1;
        }
    }

    private static void heapInsert(int[] heap, int i, int val) {
        heap[i] = val;
        while (heap[i] < heap[(i - 1) / 2]) {
            swap(heap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l < r) {
            swap(arr, l + (int) (Math.random() * (r - l + 1)), r);
            int[] p = partition(arr, l, r);
            quickSort(arr, l, p[0] - 1);
            quickSort(arr, p[1] + 1, r);
        }
    }

    private static int[] partition(int[] arr, int l, int r) {
        int less = l - 1;
        //快排每次比较的是r位置的数，这里我们为了复用变量，将more初始化为r
        int more = r;
        while (l < more) {
            if (arr[l] > arr[r]) {
                swap(arr, --more, l);
            } else if (arr[l] < arr[r]) {
                swap(arr, ++less, l++);
            } else {
                l++;
            }
        }
        swap(arr, more, r);
        return new int[]{less + 1, more};
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12, 432, 4, 2, 314, 23, 15, 123, 4, 1, 23, 32};
        //quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(topN(arr, 6 )));
    }
}
