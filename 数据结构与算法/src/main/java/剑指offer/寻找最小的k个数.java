package 剑指offer;

import java.util.ArrayList;
import java.util.Arrays;

import static 剑指offer.三丶数组中重复的数字.swap;

public class 寻找最小的k个数 {

    public static void main(String[] args) {

        int[] arr = new int[]{0,1,2,1};
        int[] heap = buildHeap(arr,1);
        System.out.println(Arrays.toString(heap));
    }

    public static int[] buildHeap(int[] arr, int k){
        int[] heap = new int[k];
        System.arraycopy(arr,0,heap,0,k);
        System.out.println(Arrays.toString(heap));
        heapSort(heap);
        for (int i = k; i < arr.length; i++){
            if (arr[i] < heap[0]){
                heap[0] = arr[i];
                heapify(heap,0);
            }
        }
        return heap;
    }

    public static void heapSort(int[] arr){
        for (int i = (arr.length-1)/2 ; i >= 0; i--){
            heapify(arr,i);
        }
    }

    public static void heapify(int[] arr,int root){
        int l = 2 * root + 1;
        int r = 2 * root + 2;
        int max = arr[root];

        if (l < arr.length && max < arr[l]){
            max = arr[l];
        }
        if (r < arr.length  && max < arr[r]){
            max = arr[r];
        }
        if (l < arr.length && max == arr[l]){
            swap(arr,root,l);
            heapify(arr,l);
        }
        if (r < arr.length && max == arr[r]){
            swap(arr,root,r);
            heapify(arr,r);
        }
    }
}
