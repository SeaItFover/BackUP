package 剑指offer;

import java.util.Arrays;

public class 三丶数组中重复的数字 {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,1,0,2,5,3};
        int[] result={};
        System.out.println(Arrays.toString(searchDul(arr)));
    }

    public static int[]  searchDul(int[] arr){

        if (arr == null || arr.length <= 1){
            return null;
        }
        for (int i = 0; i<arr.length; i++){
            while (arr[i] != i){
                if (arr[i] == arr[arr[i]]){
                    return new int[]{arr[i]};
                }
                swap(arr,i,arr[i]);
            }
        }

        return null;
    }

    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

//    public static boolean searchDul(int[] arr, int[] result){
//        for (int i=0; i<arr.length; i++){
//            while (arr[i] != i){
//                if (arr[i] == arr[arr[i]]){
//                    result[0] = arr[i];
//                    return true;
//                }
//                int temp = arr[i];
//                arr[i] = arr[arr[i]];
//                arr[arr[i]] =temp;
//            }
//        }
//        return false;
//    }

    //public static void swap()
//    public static int searchDul(int[] arr){
//        for (int i = 0; i<arr.length; i++){
//            for (int j = 0 ;j<arr.length;j++){
//                if (arr[i] == i){
//                    continue;
//                }else{
//                    if (arr[i] == arr[arr[i]]){
//                        return arr[i];
//                    }else{
//                        int temp = arr[i];
//                        arr[i] = arr[arr[i]];
//                        arr[arr[i]] =temp;
//                    }
//                }
//            }
//
//        }
//    }
//
//}
