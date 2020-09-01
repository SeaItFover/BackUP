package Java多线程.每日练习;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class 三个工具类 {

    public static void main(String[] args) {
        tetsCyclicBarrier();

    }

    public static void tetsCyclicBarrier(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4,()->{
            System.out.println("召唤shenlong");
        });
        for (int i = 0; i < 4; i++){
            new Thread(()->{
                System.out.println("收集");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },"").start();
        }
    }

    public static void testSemaphore(){
        Semaphore s = new Semaphore(4);
    }
}
