package 算法课程.数组中的问题最常见;

import java.util.Arrays;

/**
 * 80给定一个有序数组，对数组中的元素去重，使得原数组中的每个元素最多保留两个。返回去重后数组的长度值
 */
public class 去重数组并最多保留两个 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,2,2,3};
        System.out.println(removeElement(arr));
        System.out.println(Arrays.toString(arr));
    }

    private static int removeElement(int[] arr) {
        int k = arr.length;
        for (int i = 0; i < arr.length-2; i++){
            if (arr[i] == arr[i+1]){
                if (arr[i+1] == arr[i+2]){
                    arr[i+2] = 0;
                    k--;
                }
            }
        }
        int[] ret = new int[k];
        int i = 0;
        for (int n : arr){
            if (n != 0){
                ret[i++] = n;
            }
        }
        return ret.length;
    }

}
