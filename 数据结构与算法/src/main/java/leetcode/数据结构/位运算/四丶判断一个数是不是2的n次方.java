package leetcode.数据结构.位运算;

public class 四丶判断一个数是不是2的n次方 {
    public static void main(String[] args) {
        int[] ar = new int[9];
        System.out.println(ar[9]);
    }

    public static boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 0;
    }

    public static boolean isPowerOfTwo2(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
