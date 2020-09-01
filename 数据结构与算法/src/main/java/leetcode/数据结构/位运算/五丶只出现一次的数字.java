package leetcode.数据结构.位运算;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 一个非空数组中，其余数字都出现了三次，只有一个数字出现了一次
 * 统计二进制位中每一位级上1的个数，如果是3的倍数，那么那个数字的该位上为0；反之为1
 */
public class 五丶只出现一次的数字 {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 1, 1, 4, 2, 2, 2, 5, 5, 5};
        //System.out.println(singleNumber(arr));
        //System.out.println(singleNumber2(arr));
        System.out.println(singleNumber3(arr));
    }

    //位运算：计算每一位级二进制上1的个数
    public static int singleNumber(int[] arr) {
        int ret = 0;
        int count = 0;
        for (int i = 1; i <= 32; i++) {
            for (int j = 0; j < arr.length; j++) {
                if ((arr[j] & 1) == 1) {
                    count++;
                }
                arr[j] = arr[j] >> 1;
            }
            if ((count % 3) == 1) {
                ret = ret + (int) Math.pow(2, i - 1);
            }
            count = 0;
        }
        return ret;
    }

    //利用set集合的去重性
    public static int singleNumber2(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int sum2 = 0;
        for (int n : arr) {
            set.add(n);
            sum2 += n;
        }
        int sum1 = 0;
        for (int n : set) {
            sum1 += n;
        }
        return (sum1 * 3 - sum2) / 2;
    }

    //利用hashMap的kv键值对，储存每一个数字出现的次数
    public static int singleNumber3(int[] arr) {
        int ret = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            if (map.containsKey(n)) {
                //int k = map.get(n);
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
            System.out.println(map);
        }
        System.out.println(map);
        for (int n : map.keySet()) {
            if (map.get(n) == 1) {
                ret = n;
            }
        }
        return ret;
    }
}
