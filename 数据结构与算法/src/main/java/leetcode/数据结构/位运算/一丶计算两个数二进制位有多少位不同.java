package leetcode.数据结构.位运算;

/**
 * 思想：两个数的二进制位只要不同，那么异或运算之后这些位置就是1.
 * 所以思路就是先对两个数进行异或运算之后，然后统计运算之后这个数中包含多少个1.
 * 后一步也就是一个数包含多少个1有三种思路：
 * 1.从右往左统计，由于z & 1 == 1说明z的最后一位是1
 */
public class 一丶计算两个数二进制位有多少位不同 {

    public static void main(String[] args) {
        System.out.println(hammingDistance1(1, 4));
        System.out.println(hammingDistance2(1, 4));
        System.out.println(hammingDistance3(1, 4));

    }

    public static int hammingDistance1(int a,int b){
        int z = a ^ b;
        int count = 0;
        while (z != 0){
            if ((z & 1) == 1){
                count++;
            }
            z = z >> 1;
        }
        return count;
    }

    public static int hammingDistance2(int a,int b){
        int z =  a ^ b;
        int count = 0;
        while (z != 0){
            z = z & (z-1);
            count++;
        }
        return count;
    }

    public static int hammingDistance3(int a,int b){
        return Integer.bitCount(a ^ b);
    }
}
