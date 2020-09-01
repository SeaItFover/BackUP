package 排序与查找.sort.selectsort;

import java.util.Arrays;

/**
 * 第一次写选择排序出错点：
 * 在找到最小数的指标时，只是将最小数赋值给最前面的元素（除去前面几轮已经排序好的数）
 * 导致数被不断覆盖
 * 应该将最小数与最前面的数交换，这样才不会丢失数据
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,3,9,1,0,8,7,4,2};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){
        //所谓选择排序就是循环n-1次
        // 每一轮记录最小的数的指标，寻找结束后将其与第i个元素交换（i就是第i轮循环）
        for (int i = 0; i<arr.length-1; i++){
            int minIndex = i;
            System.out.println("第"+(i+1)+"轮未排序数组"+Arrays.toString(arr));
            for (int j = i+1; j<arr.length; j++){
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
            System.out.println("第"+(i+1)+"轮已排序数组"+Arrays.toString(arr));
        }
    }
}
