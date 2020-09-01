package 算法课程.数组中的问题最常见;

/**
 * 27给定一个数组，给定一个数字，删除数组中和该数字相等的元素，并且返回数组中剩余元素的个数。
 */
public class 删除数组中指定元素 {
    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1,2,3};
        removeElement(arr,3);
    }

    public static int removeElement(int[] arr,int target){
        if (arr.length == 0 || arr == null){
            throw new IllegalArgumentException("Array is illegal!");
        }
        return -1;
    }
}
