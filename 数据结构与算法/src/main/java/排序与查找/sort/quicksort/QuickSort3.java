package 排序与查找.sort.quicksort;

import java.util.Arrays;

public class QuickSort3 {

    public static void main(String[] args) {
        int[] arr =new int[]{4,5,2,1,0,9,6,8,5};
        quickSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr,int start,int end){
        if (start < end){
            int standard = arr[start];
            int low = start;
            int high = end;
            while (low < high){
                while (low < high && arr[high] >= standard){
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= standard){
                    low++;
                }
                arr[high] = arr[low];
            }

            arr[low] = standard;

        }
    }
}
