package leetcode.算法思想.动态规划.斐波那契数列;

/**
 * 递归中也有爬楼梯的思想，比较递归以及动态规划的区别
 *
 * 假设一个人一次最多只能爬两阶台阶，试计算爬n阶台阶一共有几种办法
 */
public class 爬楼梯 {
    public static void main(String[] args) {
        System.out.println(countStep(8));
        System.out.println(countStep1(8));
    }

    public static int countStep1(int n){

        if (n <= 2){

            System.out.println("hahh ");
            return n;
        }
        return countStep1(n-1)+countStep1(n-2);
    }

    public static int countStep(int n){
        if (n<=2){
            System.out.println("jlall");
            return n;
        }
        int result = 0;
        int pr1 = 1;
        int pr2 = 2;
        for (int i = 2; i<n; i++){
            result = pr1 + pr2;
            pr1 = pr2;
            pr2 = result;
        }
        return result;
    }
}
