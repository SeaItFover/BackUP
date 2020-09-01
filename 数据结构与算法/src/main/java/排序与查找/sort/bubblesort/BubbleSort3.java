package 排序与查找.sort.bubblesort;

import java.util.Arrays;

public class BubbleSort3 {

    public static void main(String[] args) {

        int[] arr = new int[]{7,3,2,9,4,1,0,5,6,8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0; i<arr.length-1; i++){
            for (int j = 0; j<arr.length-1-i; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}


