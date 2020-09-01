package 算法课程;

import java.util.concurrent.TimeUnit;

public class 数据规模的概念 {
    public static void main(String[] args) {
        for (int i = 1; i < 10; i++){
            int n = (int) Math.pow(10,i);
            int sum = 0;
            long startTime = System.currentTimeMillis();
            for (int x = 0; x <n; x++){
                sum += x;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("10^"+i+"次"+"运行时间为："+ TimeUnit.MILLISECONDS.toSeconds(endTime-startTime));
        }
    }
}
