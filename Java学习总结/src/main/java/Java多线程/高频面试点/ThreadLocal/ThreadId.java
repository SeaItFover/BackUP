package Java多线程.高频面试点.ThreadLocal;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ThreadLocal 的使用案例
 *
 * 给调用该方法的线程分配一个线程Id，分配完之后就不会变了，也就是每一个线程对应一个Id。
 */
public class ThreadId {

    private static final AtomicInteger nextId = new AtomicInteger(1);

    //每一个线程对应的ThreadId
    private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

    //返回当前线程对应的唯一ThreadId，必要时会进行分配
    public static int get() {
        return threadId.get();
    }

    public static void main(String[] args) throws InterruptedException {
        RunnableTask task = new RunnableTask();
        new Thread(task, "1").start();
        TimeUnit.MILLISECONDS.sleep(100);
        new Thread(task, "2").start();
        TimeUnit.MILLISECONDS.sleep(100);
        new Thread(task, "3").start();
        TimeUnit.MILLISECONDS.sleep(100);

    }

    static class RunnableTask implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("currentThreadName: " + Thread.currentThread().getName() + ", ID : " + threadId.get());
                System.out.println("currentThreadName: " + Thread.currentThread().getName() + ", ID : " + threadId.get());
                System.out.println("currentThreadName: " + Thread.currentThread().getName() + ", ID : " + threadId.get());
                System.out.println("currentThreadName: " + Thread.currentThread().getName() + ", ID : " + threadId.get());
                System.out.println("currentThreadName: " + Thread.currentThread().getName() + ", ID : " + threadId.get());
                System.out.println("currentThreadName: " + Thread.currentThread().getName() + ", ID : " + threadId.get());
                System.out.println("currentThreadName: " + Thread.currentThread().getName() + ", ID : " + threadId.get());
            }finally {
                threadId.remove();
            }
        }
    }
}
