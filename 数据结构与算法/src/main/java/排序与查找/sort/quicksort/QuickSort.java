//package com.sort.quicksort;
//
//import java.util.Arrays;
//
//public class QuickSort {
//
//    public static void main(String[] args) {
//        int[] arr = new int[]{5, 4, 2, 7, 9, 0, 3, 5};
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
//    }
//
//    public static void quickSort(int[] arr, int start, int end) {
//        if (start < end) {
//            int standard = arr[start];
//            int low = start;
//            int high = end;
//
//            while (low < high) {
//
//                //开始第一次排序
//                //high先行
//                while (low<high && arr[high] >= standard) {
//                    high--;
//                }
//                arr[low] = arr[high];
//                //low后行
//                while (low<high && arr[low] <= standard) {
//                    low++;
//                }
//                arr[high] = arr[low];
//
//            }
//            //一次大循环结束（以一个基准值排序完）将基准值归位
//            arr[low] = standard;
//            quickSort(arr, start, low);
//            quickSort(arr, low+1, end);
//        }
//    }
//}
package 排序与查找.sort.quicksort;

import java.util.Arrays;

public class QuickSort {

    static int i = 1;
    public static void main(String[] args) {
        int[] arr = new int[]{1,4,2,7,4,5};
        System.out.println(arr.length);
        //int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            System.out.println("jinlaile ");
            i++;
            System.out.println(i);
            int standard = arr[start];
            int low = start;
            int high = end;
            while (low < high) {
                while (low < high && arr[high] >= standard){
                    high--;
                }
                arr[low] = arr[high];
                while (low< high && arr[low] <= standard){
                    low++;
                }
                arr[high] = arr[low];
            }
            arr[low] = standard;
            quickSort(arr,start,low);
            quickSort(arr,low+1,end);
        }
    }
}