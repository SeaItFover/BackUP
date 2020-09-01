package Java多线程.高频面试点.CAS;

import java.util.concurrent.atomic.AtomicInteger;

public class TestCAS {

    private static int num = 0;

    public static void increment() {
        int expectNum;
        while (!compareAndSwap(expectNum = getNum(),expectNum+1)){}
        do{}while(!compareAndSwap(expectNum = getNum(),expectNum+1));
    }

    public static synchronized boolean compareAndSwap(int expect, int newNum){
        if (expect == getNum()){
            num = newNum;
            return true;
        }
        return false;
    }

    public static int getNum() {
        return num;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++){
            new Thread(() -> {
                for (int j = 0; j < 100; j++){

                    increment();
                }
            }).start();
        }
        while (Thread.activeCount() > 2){
            Thread.yield();
        }
        System.out.println(num);
    }

    /*private volatile int num = 0;

    private void incrementNum(){
        while (compareAndSwap()){
            num++;
        }
    }

    int expectNum = getNum();
    int n = 0;
    private boolean compareAndSwap(){
        if (expectNum == getNum()){
            return true;
        }
        return false;
    }

    private int getNum(){
        return num;
    }

    public static void main(String[] args) {
        TestCAS testCAS = new TestCAS();
        for (int i = 0; i < 100; i++){
            new Thread(() -> {
                for (int j = 0; j < 200; j++){
                    testCAS.incrementNum();
                }
            }).start();
        }
        if (Thread.activeCount() > 1){
            Thread.yield();
        }
        System.out.println(testCAS.num);
    }*/
}
