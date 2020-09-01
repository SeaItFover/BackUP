package 算法课程.数组中的问题最常见;

import java.util.Arrays;

/**
 * 75，给定一个有n个元素的数组，数组中元素取值只有0,1,2三种可能。为这个数组排序
 */
public class 数组排序 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,1,0,2,0,2};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 由于只有三种元素取值可能，所以可以统计每个元素出现的次数，然后一次将他们放入原数组
     */
    public static void sortColors(int[] arr){
        int[] counts = new int[3];
        for (int n : arr){
            counts[n]++; //利用数组元素值和数组下标之间的关系
        }
        int index = 0;
        for (int i = 0,j = 0; i < counts[j] && j<=2; i++,j++){
            arr[index++] = j;
        }/*for (int i = 0; i < counts[1]; i++){
            arr[index++] = 1;
        }for (int i = 0; i < counts[2]; i++){
            arr[index++] = 2;
        }*/
    }
}
