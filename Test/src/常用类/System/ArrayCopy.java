package 常用类.System;

import java.util.Arrays;

public class ArrayCopy {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,9,8};
        int[] arr2 = new int[10];
        System.arraycopy(arr,0,arr2,0,arr.length);
        System.out.println(Arrays.toString(arr2));
    }
}
