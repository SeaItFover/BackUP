package Java多线程.高频面试点.volatile关键字;

/**
 * volatile保证变量在线程之间的可见性，但是并不保证原子性
 * 它只有两个作用：可见性、有序性
 */
public class IntTranIntegr {
    private static  int num = 0;

    private static final int threadNums = 100;

    public static synchronized void incrementNum() {
        num++;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[threadNums];
        for (int i = 0; i < threadNums; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 200; j++) {
                    incrementNum();
                }
            });
            threads[i].start();

        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(num);
    }
}
