package 线程间的通信;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目要求：多线程之间顺序调用，实现A->B->C
 * 三个线程启动，要求如下：
 *
 * AA打印5次，BB打印10次，CC打印15次
 * 接着
 * AA打印5次，BB打印10次，CC打印15次
 * 。。。。来10轮
 */
class Print{
    private int num = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void print5(){
        while (num != 1){
            try {
                condition1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 5; i++){
            System.out.println("AA");
        }
        num = 2;
        condition2.signal();
    }

    public void print10(){
        while (num != 2){
            try {
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 10; i++){
            System.out.println("BB");
        }
        num = 3;
        condition3.signal();
    }

    public void print15(){
        while (num != 3){
            try {
                condition3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < 15; i++){
            System.out.println("CC");
        }
        num = 1;
        condition1.signal();
    }
}

public class Instance01 {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                print.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                print.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                print.print15();
            }
        },"C").start();
    }
}
