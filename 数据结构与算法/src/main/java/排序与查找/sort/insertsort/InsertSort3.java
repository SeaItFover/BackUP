package 排序与查找.sort.insertsort;

import java.util.Arrays;

public class InsertSort3 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,2,8,5,9,1,0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
//        for (int i = 1; i<arr.length; i++){
//            for (int j = i-1; j>=0;   j--){
//                if (arr[j] > arr[j+1]){
//                    int temp = arr[j];
//                    arr[j] = arr[j+1];
//                    arr[j+1] = temp;
//                }
//            }
//        }
        for (int i =1 ; i<arr.length;i++){
            int j;
            int temp =arr[i];
            for (j = i-1; j>=0;j--){
                if (arr[j] > temp){
                    arr[j+1] = arr[j];
                }
            }

            arr[j+1] = temp;
        }
    }
}
