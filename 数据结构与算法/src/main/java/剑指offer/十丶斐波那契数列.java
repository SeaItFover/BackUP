package 剑指offer;

/**
 * 三种方式：循环、递归、矩阵
 */
public class 十丶斐波那契数列 {
    public static void main(String[] args) {
        System.out.println(Fibonacci(10));
        System.out.println(Fibonacci3(10));
    }

    //循环求解第n个值（但是不保存过程中的每一个值）
    public static int Fibonacci(int n){
        if(n<0){
            System.out.println("输入不合理！");
        }
        if (n<2){
            return n;
        }
        int pre1 = 1;
        int pre2 = 0;
        int fib =0;
        for (int i = 2; i<= n; i++){
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    //直接的递归解法
    public static int Fibonacci2(int n){
        if(n<0){
            System.out.println("输入不合理！");
        }
        if (n<2){
            return n;
        }
        return Fibonacci2(n-1)+Fibonacci2(n-2);
    }

    //循环求解得到第n个值（并且保存过程中的每一个值）
    public static int Fibonacci3(int n ){
        if(n<0){
            System.out.println("输入不合理！");
        }
        int[] fib = new int[n+1];
        fib[1] = 1;
        for (int i = 2; i<=n; i++){
            fib[i] = fib[i-1] +fib[i-2];
        }
        return fib[n];
    }
}
