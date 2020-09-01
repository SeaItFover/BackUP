package 算法课程.数组中的问题最常见;

import java.util.Arrays;

/**
 * 将数组中的零元素全部移动到数组末尾，同时不改变非零元素的相对位置
 */
public class 移动数组中的零元素 {
    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12,0,2,2,0,0,1,2};
        //System.out.println(Arrays.toString(moveZeros(arr)));
        moveZeros2(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 最直接的想法：取出数组中所有非零元素，将其依次放入原数组，然后后面的值全部赋为0
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
    public static int[] moveZeros(int[] arr){
        int[] ret = new int[arr.length];
        int i = 0;
        for (int n:arr){
            if (n != 0){
                ret[i++] = n;
            }
        }
        return ret;

    }

    /**
     * 不用额外的空间，直接在数组中操作，其中一个指针指向非零元素，另一个指针遍历数组
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public static void moveZeros2(int[] arr){
        int k = 0;
        for (int i= 0; i< arr.length; i++){
                if (arr[i] != 0){
                    if (i!=k){
                        int temp = arr[i];
                        arr[i] = arr[k];
                        arr[k++] = temp;
                    }else{
                        k++;
                    }
            }
        }
    }
}
