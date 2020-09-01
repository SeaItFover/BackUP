package 排序与查找.sort.shellsort;

import java.util.Arrays;

/**
 * 希尔排序是特殊的插入排序
 * 当步长为零时，其是直接插入排序
 *
 */
public class ShellSort1 {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 8, 7, 6, 2, 9, 1, 0, 4, 3};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        for (int d = arr.length / 2; d > 0; d /= 2) {
            //希尔排序内部是插入排序
            for (int i = d; i < arr.length; i++) {
                /*for (int j = i - d; j >= 0; j -= d) {
                    if (arr[j] > arr[j + d]) {
                        int temp = arr[j];
                        arr[j] = arr[j + d];
                        arr[j + d] = temp;
                    }
                }*/
                int temp = arr[i];
                int j;
                for ( j = i - d; j >= 0 && temp < arr[j]; j-=d) {
                    arr[j+d] = arr[j];
                }
                //把临时变量（外层for循环的当前元素）赋给不满足条件的后一个元素
                arr[j+d] = temp;
            }
        }
    }
}
