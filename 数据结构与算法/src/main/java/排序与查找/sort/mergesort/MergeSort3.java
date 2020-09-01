package 排序与查找.sort.mergesort;

import java.util.Arrays;

public class MergeSort3 {
    public static void main(String[] args) {
        int[] arr = new int[]{6,4,9,0,1,4,2,3,5,7,8};
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int low, int high){
        if (low < high){
            int middle = (low+high)/2;
            mergeSort(arr,low,middle);
            mergeSort(arr,middle+1,high);
            merge(arr,low,middle,high);
        }
    }

    public static void merge(int[] arr,int low, int middle,int high){
        int i = low;
        int j = middle+1;
        int[] temp = new int[high-low+1];
        int index = 0;

        while (i <= middle && j <= high){
            if (arr[i] <= arr[j]){
                temp[index] = arr[i];
                index++;
                i++;
            }else {
                temp[index++] = arr[j++];
            }
        }

        while (i <= middle){
            temp[index++] = arr[i++];
        }
        while ( j<= high ){
            temp[index++] = arr[j++];
        }

        for (int m = 0; m<temp.length; m++){
            arr[low+m] = temp[m];
        }
    }
}
