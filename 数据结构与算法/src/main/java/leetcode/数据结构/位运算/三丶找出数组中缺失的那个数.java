package leetcode.数据结构.位运算;

public class 三丶找出数组中缺失的那个数 {

    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 5};
        System.out.println(mySolution(arr));
        System.out.println(misSingleNumber(arr));
    }

    public static int mySolution(int[] arr) {
        int ret = 0;
        //int temp = 0;
        for (int i = 1; i <= arr.length; i++) {
            ret = ret ^ i;
        }
        for (int i = 0; i < arr.length; i++) {
            ret = ret ^ arr[i];
        }


        return ret ^ (arr.length+1);
    }

    public static int misSingleNumber(int[] arr) {
        int ret = 0;
        for (int i = 0; i < arr.length; i++) {
            ret = ret ^ i ^ arr[i];
        }
        return ret ^ arr.length ^ (arr.length+1);
    }
}
