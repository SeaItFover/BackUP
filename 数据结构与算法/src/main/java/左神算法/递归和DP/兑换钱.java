package 左神算法.递归和DP;

/**
 * 一个数组中存放着各种面额的硬币，问一共有多少中兑换的方式
 *
 * 暴力
 */
public class 兑换钱 {

    //暴力递归
    public static int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    private static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{200, 50 ,10};
        System.out.println(coins1(arr, 5));
    }
}
