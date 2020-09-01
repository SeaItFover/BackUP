package 算法课程.动态规划;

import java.util.ArrayList;

public class 斐波那契数列的实现 {
    public static void main(String[] args) {
        System.out.println(fib(3));
    }

    public static int fib(int n){
        ArrayList<Integer> arrayList = new ArrayList(n);

        arrayList.add(0);
            arrayList.add(1);

        for (int i = 2; i <= n; i++){
            arrayList.add(arrayList.get(i-1) + arrayList.get(i-2));
        }

        return arrayList.get(n);
    }
}
