package 算法课程.数组中的问题最常见;

import java.util.Arrays;

/**
 * 归并排序本质上是对两个数组进行排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,2,4,8,7,9};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr,int low,int high){
        int middle = (low + high)/2;
        if (low < high){
            mergeSort(arr,low,middle);
            mergeSort(arr,middle+1,high);
            merge(arr,low,middle,high);
        }
    }

    public static void merge(int[] arr,int low,int middle,int high){
        int[] temp = new int[high-low+1];
        int i = low;
        int j = middle+1;
        int index = 0;

        while (i <= middle && j <= high){
            if (arr[i] <= arr[j]){
                temp[index++] = arr[i++];
            }else {
                temp[index++] = arr[j++];
            }
        }
        while (i <= middle){
            temp[index++] = arr[i++];
        }
        while (j <= high){
            temp[index++] = arr[j++];
        }
        for (int k = 0; k<temp.length;k++){
            arr[low+k] = temp[k];
        }
    }
}
