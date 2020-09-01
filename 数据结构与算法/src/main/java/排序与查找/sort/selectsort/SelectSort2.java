package 排序与查找.sort.selectsort;

import java.util.Arrays;

public class SelectSort2 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 9, 0, 4, 8, 6, 7, 1, 3};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i+1; j<arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
