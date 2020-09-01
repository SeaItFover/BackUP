package Java多线程.高频面试点.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class CasABA {

    private static AtomicInteger a = new AtomicInteger(1);

    public static void main(String[] args) {
        new Thread(() -> {
            int expectNum = a.get();
            int newNum = expectNum + 1;
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean isSuccess = a.compareAndSet(expectNum, newNum);
            System.out.println(isSuccess);
        },"main").start();

        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a.incrementAndGet();
            a.decrementAndGet();
            System.out.println(Thread.currentThread().getName() + a.get());
        },"disturb").start();
    }

}
