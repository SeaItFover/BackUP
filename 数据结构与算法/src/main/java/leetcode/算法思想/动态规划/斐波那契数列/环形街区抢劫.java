package leetcode.算法思想.动态规划.斐波那契数列;

/**
 * 相比一排住户，环形街区特点就是首尾相连，那么特殊之处就在于如何处理头和尾不能都偷。
 * 如果偷头，那么尾不能偷，如果跳过头，从第二个开始偷，那么可以偷到尾
 *
 */
public class 环形街区抢劫 {
    public static void main(String[] args) {
        int[] m = new int[]{1,2,4};
        System.out.println(rob(m));
    }

    public static int rob(int[] money){
        if (null == money || money.length == 0){
            return 0;
        }
        int n = money.length;
        return Math.max(rob(money,0,n-2),rob(money,1,n-1));
    }

    private static int rob(int[] money,int start, int end){
        int pr1 = 0;
        int pr2 = 0;
        int result = 0;
        for(int first = start;first<=end;first++){
            result = Math.max((pr1 + money[first]),pr2);
            pr1 = pr2   ;
            pr2 = result;
        }
        return result;
    }
}
