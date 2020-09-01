package 算法课程.数组中的问题最常见.滑动窗口;

/**
 * 209给定一个整型数组和一个数字s，找到数组中最短的一个连续子数组，使得连续子数组的数字和
 * sum >= s，返回这个最短最短的连续子数组。
 * 每个子数组都是由i和j决定的，所以我们使用双重循环。
 */
public class 最短连续子数组 {
    public static void main(String[] args) {
        int[] arr = new int[]{2,3,1,2,4,3};//s = 7,return [4,3]
        System.out.println(minSubArrayLen(arr,6));
    }

    public static int minSubArrayLen(int[] arr, int s){
        int l = 0;
        int r = -1;
        int sum = 0;
        int res = arr.length+1;

        while (l < arr.length && r < arr.length){
            if (r+1 < arr.length && sum < s){
                sum += arr[++r];
            }else{
                sum -= arr[l++];
            }
            if (sum >= s){
                res = Math.min(res,r-l+1);
            }
        }

        if (res == arr.length+1){
            return 0;
        }
        return res;
    }
}
