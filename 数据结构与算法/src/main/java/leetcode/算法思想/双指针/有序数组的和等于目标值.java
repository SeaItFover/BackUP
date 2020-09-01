package leetcode.算法思想.双指针;

import java.util.Arrays;

/**
 * 有一个有序数组，找出其中两个值，使它们的和等于目标值
 */
public class 有序数组的和等于目标值 {
//    public static int[] twoSum(int[] numbers, int target) {
//        if (numbers == null){
//            return null;
//        }
//        int i = 0, j = numbers.length - 1;
//        while (i < j) {
//            int sum = numbers[i] + numbers[j];
//            if (sum == target) {
//                //return new int[]{i + 1, j + 1};
//                return new int[]{numbers[i],numbers[j]};
//            } else if (sum < target) {
//                i++;
//            } else {
//                j--;
//            }
//        }
//        return null;
//    }
    public static int[] twoSum(int[] arr,int target){
        if (arr == null || arr.length<=1){
            return null;
        }
        int i = 0;
        int j = arr.length-1;
        while (i <= j){
            if (arr[i] +arr[j] <target){
                i++;
            }else if (arr[i] +arr[j] > target){
                j--;
            }else{
                return new int[]{arr[i],arr[j]};
            }
        }
        return null;
    }
    public static int[] findVal(int[] arr, int target){
        int[] val = new int[2];
        int i = 0;
        int j = arr.length-1;
        while (i <= j && val[0]==0){
            if ((arr[i] + arr[j]) < target){
                i++;
            }else if((arr[i] + arr[j] )> target){
                j--;
            }else{
                val[0] = arr[i];
                val[1] = arr[j];
            }
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new int[2]));
        System.out.println("===============");
        int[] arr = new int[]{2,7,11,15};
        System.out.println(Arrays.toString(twoSum(arr,9)));
        System.out.println("++++++++++++=");
        int[] result = findVal(arr,9);
        System.out.println(Arrays.toString(result));
    }
}
