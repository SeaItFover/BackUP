package leetcode.数据结构.数组.稀疏数组;

import java.util.LinkedList;

public class Test01 {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        System.out.println(l.size());
        int[][] arr = new int[10][10];
        arr[4][5] = 1;
        arr[3][5] = 1;
        arr[6][7] = 1;
        arr[2][5] = 1;
        arr[4][6] = 1;
        arr[3][7] = 1;
        arr[4][8] = 1;
        arr[5][5] = 1;
        arr[6][6] = 1;
        SparseArray.printArr(arr);
        int[][] sparsrArr = SparseArray.toSparseArr(arr);

        SparseArray.printArr(sparsrArr);
        int[][] arr2 = SparseArray.toDeArr(sparsrArr);
        SparseArray.printArr(arr2);
    }
}
