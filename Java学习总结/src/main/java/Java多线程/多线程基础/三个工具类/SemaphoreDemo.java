package Java多线程.多线程基础.三个工具类;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
/**
 * 以前学的多线程我们是多个线程争夺一个资源，现在是多个线程争夺多个资源
 * 但是资源有限，也就类似锁的数量固定，同一时间只有这个数量的线程可以进入
 * 之前的多线程只有一个锁，同一时间只有一个线程可以进入。
 *
 * 信号灯工具类
 * 下面主要有两个方法
 * 一个是获取acquire
 * 一个是释放release
 * 也就是只有当某个线程用完资源类的时候，才会释放
 *
 *
 * 线程体、资源类、类中的方法
 */

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 7; i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"得到了车位");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"离开了车位");
                    semaphore.release(); //为什么要写在finally里面而不是try里面
                } catch (InterruptedException e) {
                    e.printStackTrace();}
//                }finally{
//                    semaphore.release();
//                }
            },String.valueOf(i)).start();
        }
    }
}
