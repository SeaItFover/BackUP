package 排序与查找.sort.quicksort;

import java.util.Arrays;

/**
 * 第二次快排出错：在指标移动时，每次循环判断忘记添加low<high，
 * 为什么要加入start<end这个判断条件，是因为start可能会和end同时等于0
 * 0,9
 * 0,4
 * 0,3
 * 0,1
 * 0,0
 * 0,0
 * 0,0
 * 0,0
 * 0,0
 * 0,0
 * 0,0
 * 0,0
 * 0,0
 * 0,0
 * 0,0
 */

public class QuickSort1 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 2, 5, 1, 0, 3, 9, 8, 7, 6};
        quicksort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quicksort(int[] arr, int start, int end) {
        System.out.println(start+","+end);
            int low = start;
            int high = end;
            int standrad = arr[start];
            while (low < high){
                while (low <high && arr[high] >= standrad){
                    high--;
                }
                arr[low] = arr[high];
                while (low<high && arr[low]<= standrad){
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = standrad;
            quicksort(arr,start,low);
            quicksort(arr,low+1,end);





    }
}
