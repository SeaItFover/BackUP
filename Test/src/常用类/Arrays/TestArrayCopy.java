package 常用类.Arrays;

import java.util.Arrays;

public class TestArrayCopy {
    public static void main(String[] args) {
        int[] arr = {3,4,1,5,1,56};
        System.out.println(Arrays.toString(Arrays.copyOf(arr,arr.length-1)));
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,1,arr.length)));
    }
}
