package Java多线程.高频面试点.CAS;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * CAS(compareAndSwap)
 */
public class MyCAS {
    private volatile static int num;

    public static int getNum() {
        return num;
    }

    public static void increment() {
        int expect = getNum();
        synchronized (MyCAS.class) {
            while (expect == getNum()) {
                num++;
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    increment();
                }
            }).start();
        }

        Thread.sleep(2000);
        System.out.println(num);
    }
}
