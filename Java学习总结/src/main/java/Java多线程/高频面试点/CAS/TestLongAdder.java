package Java多线程.高频面试点.CAS;

import java.util.concurrent.atomic.LongAdder;

public class TestLongAdder {

    private static LongAdder adder = new LongAdder();
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++){
            new Thread(()->{
                for (int j = 0; j < 100; j++){
                    adder.add(2L);
                }
            },"").start();
        }


        Thread.sleep(5000);
        System.out.println(adder.sum());
    }
}
