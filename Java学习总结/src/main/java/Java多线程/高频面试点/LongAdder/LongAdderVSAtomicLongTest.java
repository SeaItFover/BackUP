package Java多线程.高频面试点.LongAdder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * ClassName: LongAdderVSAtomicLongTest
 * Description:
 * date: 2020/2/25 18:28
 *
 * @author 暴躁小刘讲师，微信：vv517956494
 * 想要购买本套JDK 1.8 ConcurrentHashMap 源码讲解课程的同学，可以加我微信！
 * 我摊牌了，我就是来卖课的...（家里的孩子还等着我赚钱买奶粉呢...）
 * <p>
 * 小刘讲师决定站着把钱挣了，如果购买后感觉课程不硬核并且指出问题所在，
 * 小刘讲师立刻返还所有课程费用，一分钱不收！
 * @since 1.0.0
 */
public class LongAdderVSAtomicLongTest {




    public static void main(String[] args){

        System.out.println(16 / 0.75);
        //0000 0000 0000 0000 0000 0000 0000 0100
        testAtomicLongVSLongAdder(1, 10000000);

        testAtomicLongVSLongAdder(10, 10000000);

        testAtomicLongVSLongAdder(20, 10000000);

        testAtomicLongVSLongAdder(40, 10000000);

        testAtomicLongVSLongAdder(80, 10000000);
    }

    /**
     * @param threadCount 开启线程数
     * @param times 累加次数
     */
    static void testAtomicLongVSLongAdder(final int threadCount, final int times){
        try {
            System.out.println("threadCount：" + threadCount + ", times：" + times);
            long start = System.currentTimeMillis();
            testLongAdder(threadCount, times);
            System.out.println("LongAdder elapse：" + (System.currentTimeMillis() - start) + "ms");

            long start2 = System.currentTimeMillis();
            testAtomicLong(threadCount, times);
            System.out.println("AtomicLong elapse：" + (System.currentTimeMillis() - start2) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    static void testAtomicLong(final int threadCount, final int times) throws InterruptedException {
        AtomicLong atomicLong = new AtomicLong();
        List<Thread> list = new ArrayList<>();
        for (int i=0;i<threadCount;i++){
            list.add(new Thread(() -> {
                for (int j = 0; j<times; j++){
                    atomicLong.incrementAndGet();
                }
            }));
        }

        for (Thread thread : list){
            thread.start();
        }

        for (Thread thread : list){
            thread.join();
        }
    }

    static void testLongAdder(final int threadCount, final int times) throws InterruptedException {
        LongAdder longAdder = new LongAdder();
        List<Thread> list = new ArrayList<>();
        for (int i=0;i<threadCount;i++){
            list.add(new Thread(() -> {
                for (int j = 0; j<times; j++){
                    longAdder.add(1);
                }
            }));
        }

        for (Thread thread : list){
            thread.start();
        }

        for (Thread thread : list){
            thread.join();
        }
    }
}
