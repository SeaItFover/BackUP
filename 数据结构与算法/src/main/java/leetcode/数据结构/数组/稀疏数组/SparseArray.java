package leetcode.数据结构.数组.稀疏数组;

import java.util.Arrays;

public class SparseArray {

    public static int[][] toSparseArr(int[][] arr){
        checkArr(arr);
        int sum = 0;
        for (int i = 0; i< arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                if (arr[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println(sum);
        int[][] sparseArr = new int[sum+1][3];
        sparseArr[0][0] = arr.length;
        sparseArr[0][1] = arr[0].length;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i<arr.length; i++){
            for (int j = 0; j<arr[i].length; j++){
                if (arr[i][j] !=0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }
        return sparseArr;
    }

    //稀疏数组传化成二维数组
    public static int[][] toDeArr(int[][] sparseArr){
        int[][] arr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i <= sparseArr[0][2]; i++){
            arr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        return arr;
    }

    public static void checkArr(int[][] arr){
        if (arr == null){
            throw new IllegalArgumentException("Array is null");
        }
    }

    public static void printArr(int[][] arr){
        checkArr(arr);
//        for (int i = 0; i<arr.length; i++){
//            for (int j = 0;j <arr[0].length; j++){
//                System.out.print(arr[i][j]+"\t");
//            }
//            System.out.println();
//        }
        for (int[] a : arr){
            System.out.println(Arrays.toString(a));
        }
    }
}