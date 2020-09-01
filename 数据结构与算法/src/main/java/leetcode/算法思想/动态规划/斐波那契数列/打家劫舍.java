package leetcode.算法思想.动态规划.斐波那契数列;

/**
 * 有一个小偷偷钱，但是不能偷邻近屋子的钱，假设数组里存放的是每户人家的钱，问能偷到的最大钱数。
 * 思路：
 * 假设要偷第k家，选择是要么不偷这一家，那么最大值为k-1
 * 要么偷这一家，最大值为k-2+第k家
 */
public class 打家劫舍 {
    public static void main(String[] args) {
        int[] money = new int[]{2,7,9,3,1};
        System.out.println(maxMoney(money));
    }

    public static int maxMoney(int[] nums){
        int pr1 =0 ;
        int pr2 = 0;
        int result = 0;
        for (int i = 0; i<nums.length;i++){
            result = Math.max(pr1+nums[i],pr2);
            pr1 = pr2;
            pr2 = result;
        }
        return result;
    }
}
