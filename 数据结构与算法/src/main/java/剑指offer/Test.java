package 剑指offer;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,0,2,5,3};
        int temp = arr[1];
        arr[1] = arr[arr[1]];
        arr[arr[1]] = temp;
        System.out.println(Arrays.toString(arr));
    }
}
