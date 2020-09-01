package Java多线程.高频面试点.LongAdder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class LongAdderVSAtomicLong {

    public static void main(String[] args) throws InterruptedException {
        testLongAdderVSAtomicLong(10,10000000);
        testLongAdderVSAtomicLong(20,10000000);
        testLongAdderVSAtomicLong(40,10000000);
        testLongAdderVSAtomicLong(80,10000000);
    }

    static void testLongAdderVSAtomicLong(int threadCount,int times) throws InterruptedException {
        long start = System.currentTimeMillis();
        testAtomicLong(threadCount,times);
        System.out.println("AtomicLong  elapse \t" + (System.currentTimeMillis()-start));

        long start1 = System.currentTimeMillis();
        testLongAdder(threadCount, times);
        System.out.println("LongAdder elapse \t" + (System.currentTimeMillis()-start));
    }

    static void testAtomicLong(int threadCount,int times) throws InterruptedException {
        CountDownLatch c = new CountDownLatch(threadCount);
        AtomicLong atomicLong = new AtomicLong();
        for (int i = 0; i < threadCount; i++){
            new Thread(()->{
                for (int j = 0; j < times; j++){
                    atomicLong.incrementAndGet();
                }
                c.countDown();
            }).start();
        }
        c.await();
    }

    static void testLongAdder(int threadCount,int times) throws InterruptedException {
        LongAdder longAdder = new LongAdder();
        CountDownLatch c = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount; i++){
            new Thread(()->{
                for (int  j= 0; j < times; j++){
                    longAdder.increment();
                }
                c.countDown();
            }).start();
        }
        c.await();
    }
}
