package 排序与查找.sort.bubblesort;
/**
 *冒泡排序的思想是从左到右相邻的两个元素进行比较，每次把两者中的最大或者最小值放到最后的位置
 * 这里注意一定是放在最后的位置
 * 无论是升序排列还是降序排列，都是将比较结果放在后面的位置。
 */

import java.util.Arrays;

public class BubbleSortDesc {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,2,9,4,1,0,5,6,8};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        for (int i =0 ;i<arr.length-1; i++){
            for (int j= 0; j<arr.length-1-i;j++){
                if (arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
            }
            }
        }
    }
}
