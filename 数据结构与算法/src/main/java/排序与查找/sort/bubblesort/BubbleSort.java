package 排序与查找.sort.bubblesort;

import java.util.Arrays;

/**
 * 第一次试写冒泡排序出错：
 * 在每轮排序时，j的值设置成i，导致出错，因为每一轮新的循环开始，
 * 我们都是从数组第一个元素开始比较，逐个比较到最后一个元素（排除前几轮已经排序好的元素）
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5,2,8,1,0,3,4,8,9};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        //所谓冒泡排序就是指每次比较相邻两个元素，将较大的值换到后边
        //每一轮比较都将本轮最大的值放到最后边，一共比较length-1次
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i<arr.length-1; i++){
            System.out.println("第"+(i+1)+"轮未排序数组"+Arrays.toString(arr));
            for (int j = 1; j<arr.length-1-i;j++){
                if (arr[j-1] > arr[j]){
                     int temp = arr[j];
                     arr[j] = arr[j-1];
                     arr[j-1] = temp;
                }
            }
            System.out.println("第"+(i+1)+"轮已排序数组"+Arrays.toString(arr));
        }

    }
}
