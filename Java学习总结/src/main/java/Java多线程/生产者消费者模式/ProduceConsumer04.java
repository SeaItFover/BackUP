package Java多线程.生产者消费者模式;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 生产者消费者初始版本04
 * Lock对应synchronized，condition中的await和signal对应object中的wait和notify
 * 那么新的技术出现解决了之前无法解决的什么问题呢？答案是线程按顺序调度
 *
 * //锁只有一个，但是有三把钥匙，钥匙和标志位同时控制这线程的执行顺序
 * //标志位是从第一个版本就一直存在的，贯穿始终，
 * //牢记多线程口诀：
 * //1.高内聚低耦合的前提下，线程操作资源类，资源类将要暴漏给外面线程的操作紧紧的守在自己内部
 * //2.多线程交互过程中，判断、干活、通知（交互过程设计到标志位的使用）
 * //3.多线程交互过程中，防止虚假唤醒
 * //4.新老锁的区别以及新锁的优点：synchronized <-> Lock ,wait <-> await , notify<-> signal
 * //5.标志位配合condition（不同线程不同钥匙）实现顺序执行线程
 *
 * 考虑这样一个问题：
 * 打印AA五次，然后打印BB10次，接着打印CC15次
 * 打印10轮
 */
//线程操作资源类，先建立一个资源类
class Print{
    //建立一个标志位
    private int num = 1; //1-A , 2-B, 3-C
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    public void print5(){
        lock.lock();
        try{
            while(num != 1){
                condition1.await();
            }
            for (int i = 0; i< 5; i++){
                System.out.println(Thread.currentThread().getName()+"/t");
            }
            //改变标志位并进行精准唤醒
            num = 2;
            condition2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print10(){

        lock.lock();
        try{
            while (num != 2){
                condition2.await();
            }
            for (int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName());
            }
            num = 3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try{
            while(num != 3){
                condition3.await();
            }
            for (int i = 0; i < 15; i++){
                System.out.println(Thread.currentThread().getName());
            }
            num = 1;
            condition1.signal();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

class ProduceConsumer04{
    public static void main(String[] args) {
        Print p = new Print();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                p.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                p.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                p.print15();
            }
        },"C").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
