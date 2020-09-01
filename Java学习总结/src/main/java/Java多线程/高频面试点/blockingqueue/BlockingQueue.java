package Java多线程.高频面试点.blockingqueue;

public interface BlockingQueue<T> {

    void put(T element);

    T take();
}
