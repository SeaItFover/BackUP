package leetcode.算法思想.双指针;

import java.util.concurrent.CountDownLatch;

/**
 * 要想测试volatile不能保证变量原子性的话，必须是用一个方法来操作num
 */
public class VolatileThreadDemo {
    private static   int num = 0;

    public synchronized static void increment(){
        num++;
    }
    public static void main(String[] args) {
        CountDownLatch c = new CountDownLatch(100);

        for (int i = 0; i < 100; i++){
            new Thread(()->{
                for (int j = 0; j < 10000; j++){
                    increment();
                }
                c.countDown();
            },String.valueOf(i)).start();
        }
        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(num);
    }
}
