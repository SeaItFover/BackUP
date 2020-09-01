package Java多线程.高频面试点.CAS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CasABASolution {
    private static AtomicStampedReference<Integer> a = new AtomicStampedReference(1, 1);

    public static void main(String[] args) {
        new Thread(() -> {
            int expectReference = a.getReference();
            int newReference = expectReference + 1;
            int expectStamp = a.getStamp();
            int newStamp = expectStamp + 1;
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(a.getStamp());
            boolean isSuccess = a.compareAndSet(expectReference, newReference, expectStamp, newStamp);
            System.out.println(isSuccess);
        }, "main").start();

        new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int expectReference = a.getReference();
            int newReference = expectReference + 1;
            int expectStamp = a.getStamp();
            int newStamp = expectStamp + 1;
            a.compareAndSet(a.getReference(), (a.getReference() + 1), a.getStamp(), (a.getStamp() + 1));
            a.compareAndSet(a.getReference(), (a.getReference() - 1), a.getStamp(), (a.getStamp() + 1));
            System.out.println(Thread.currentThread().getName() + a.getReference());
        }, "disturb").start();
    }
}
