package Java多线程.高频面试点.blockingqueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueue<T> implements BlockingQueue {

    private Lock lock = new ReentrantLock();;
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    private Object[] queue;
    private int size;
    private int count;
    private int putIndex;
    private int takeIndex;

    public ArrayBlockingQueue(int size) {
        this.size = size;
        this.count = 0;
        this.queue = new Object[size];
        this.putIndex = 0;
        this.takeIndex = 0;
    }

    @Override
    public void put(Object element) {
        lock.lock();
        try {
            if (count == size) {
                notFull.await();
            }
            queue[putIndex] = element;
            count++;
            putIndex = putIndex == size - 1 ? 0 : putIndex + 1;
            notEmpty.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Object take() {
        lock.lock();
        try {
            if (count == 0) {
                notEmpty.await();
            }
            Object element = queue[takeIndex];
            takeIndex = takeIndex == size - 1 ? 0 : takeIndex + 1;
            count--;
            notFull.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return null;
    }

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                queue.put(Integer.valueOf(i));
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "produce" + i);
            }
        }, "producer").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                Integer take = (Integer)queue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "consume" + take);
            }
        }, "consumer").start();
    }
}
