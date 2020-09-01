package 排序与查找.sort.insertsort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        //int[] arr = new int[]{4, 3, 9, 2, 0, 7, 1, 8, 5};
        int[] arr = new int[]{5,3,2,8,5,9,1,0};

        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr) {
        //把前面的所有元素都当成有序，然后拿当前元素去依次比较
        for (int i = 1; i < arr.length; i++) {
            /*int temp = arr[i];
            int j;
            for ( j = i - 1; j >= 0 && temp < arr[j]; j--) {
                arr[j+1] = arr[j];
            }
            //把临时变量（外层for循环的当前元素）赋给不满足条件的后一个元素
            arr[j+1] = temp;*/
            for (int j = i - 1; j >= 0; j -= 1) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
            }
        }
    }
}
