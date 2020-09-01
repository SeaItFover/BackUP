package Java多线程.生产者消费者模式;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者初始版本03
 * 老版本的消费者生产者模式用synchronized、wait、notifyall
 * 新版本的消费者生产者模式用Lock、await、signalall
 */
//线程操作资源类，先建立一个资源类
class AirCondition03{
    private int num = 0;
    Lock lock = new ReentrantLock();
    Condition c = lock.newCondition();

    public  void increment() throws InterruptedException {
        lock.lock();
        try{
            while (num != 0){
                c.await();
            }
            //num++;
            System.out.println(Thread.currentThread().getName() + ++num);
            c.signalAll();
        }finally {
            lock.unlock();
        }

    }
    public  void decrement() throws InterruptedException {
        lock.lock();
        try{
            while (num == 0){
                c.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+num);
            c.signalAll();
        }finally {
            lock.unlock();
        }

    }
}

public class ProduceConsumer03 {
    public static void main(String[] args) {
        AirCondition03 air = new AirCondition03();
        Runtime.getRuntime().availableProcessors();

        new Thread(()->{
            for (int i = 0; i < 10; i++){
                try {
                    air.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                try {
                    air.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                try {
                    air.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                try {
                    air.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
