package 每日练习.八月三十;

import java.util.Arrays;

public class Heap {

    public static void heapInsertForSmall(int[] heap, int i) {
         while (heap[i] < heap[(i - 1) / 2]) {
             swap(heap, i, (i - 1) / 2);
             i = (i - 1) / 2;
         }
    }

    public static void heapInsertForBig(int[] heap, int i, int val) {
        while (heap[i] > heap[(i - 1) / 2]) {
            swap(heap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void heapifyForSmall(int[] heap, int i, int heapSize) {
        int left = 2 * i + 1;
        while (left < heapSize) {
            int min = left + 1 < heapSize && heap[left + 1] < heap[left] ?
                    left + 1 : left;
            min = heap[min] < heap[i] ? min : i;
            if (min == i) {
                break;
            }
            swap(heap, min, i);
            i = min;
            left = 2 * i + 1;
        }
    }

    public static void heapifyForBig(int[] heap, int i, int heapSize) {
        int left = 2 * i + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;
            largest = heap[largest] > heap[i] ? largest : i;
            if (largest == i) {
                break;
            }
            swap(heap, largest, i);
            i = largest;
            left = 2 * i + 1;
        }
    }

    public static void heapSortByASC(int[] arr) {
        if (arr == null || arr.length == 1) {
            return;
        }
        int heapSize = arr.length;
        for (int i = 0; i < arr.length; i++) {
            heapInsertForBig(arr, i, arr[i]);
        }
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapifyForBig(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static void heapSortByDESC(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int heapSize = arr.length;
        //先构建一个小根dui
        for (int i = 0; i < arr.length; i++) {
            heapInsertForSmall(arr, i);
        }
        swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapifyForSmall(arr, 0, heapSize);
            swap(arr, 0, --heapSize);
        }
    }

    public static int[] topN(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return arr;
        }
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = arr[i];
            heapInsertForSmall(heap, i);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] > heap[0]) {
                heap[0] = arr[i];
                heapifyForSmall(heap, 0, k);
            }
        }
        return heap;
    }

    public static int[] minN(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return arr;
        }
        int[] heap = new int[k];
        for (int i = 0; i < k; i++) {
            heap[i] = arr[i];
            heapInsertForBig(heap, i, 324);
        }
        for (int i = k; i < arr.length; i++) {
            if (arr[i] < heap[0]) {
                heap[0] = arr[i];
                heapifyForBig(heap, 0, k);
            }
        }
        return heap;
    }

    private static void swap(int[] heap, int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1232,3,4,23,4,23,34,23,5,342,5,23,45,23,45,2,4};
        System.out.println(Arrays.toString(topN(arr, 6)));
        System.out.println(Arrays.toString(minN(arr, 6)));
        heapSortByASC(arr);
        heapSortByDESC(arr);
        System.out.println(Arrays.toString(arr));
    }
}
