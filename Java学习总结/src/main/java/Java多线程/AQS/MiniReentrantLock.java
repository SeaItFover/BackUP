package Java多线程.AQS;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 锁的是什么呢？ 锁的是资源 state
 */
public class MiniReentrantLock implements Lock {

    private volatile int state;

    private Thread exclusiveOwnerThread;

    //head节点对应的线程就是当前占用锁的线程。
    private Node head;
    private Node tail;

    static final class Node {
        Node prev;
        Node next;
        Thread thread;
    }

    /**
     * 模拟公平锁(FIFO)
     */
    @Override
    public void lock() {

    }

    private void acquire(int arg) {

    }

    private boolean tryAcquire(int arg) {

        if (state == 0) {

        }

        return false;
    }

    private boolean hesQueuePredecessor() {
        return false;
    }

    @Override
    public void unlock() {

    }

    private void setHead(Node node) {
        this.head = node;
        //??
        node.thread = null;
        node.prev = null;
    }

    private static final Unsafe unsafe;
    private static final long stateOffset;
    private static final long headOffset;
    private static final long tailOffset;

    static {
        try{
            Field f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);

            stateOffset = unsafe.objectFieldOffset
                    (MiniReentrantLock.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset
                    (MiniReentrantLock.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset
                    (MiniReentrantLock.class.getDeclaredField("tail"));
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    private final boolean compareAndSetHead(Node update) {
        return unsafe.compareAndSwapObject(this, headOffset, null, update);
    }

    private final boolean compareAndSetTail(Node expect, Node update) {
        return unsafe.compareAndSwapObject(this, tailOffset, expect, update);
    }

    protected final boolean compareAndSetState(int expect, int update) {
        return unsafe.compareAndSwapObject(this, stateOffset, expect, update);
    }
}
