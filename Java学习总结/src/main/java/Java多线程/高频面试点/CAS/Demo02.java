package Java多线程.高频面试点.CAS;

import java.util.concurrent.CountDownLatch;

public class Demo02 {
    //总访问量
    private static int num;

    //访问方法
    public static void request() throws InterruptedException {

        //int expectNum = getNum(); //error 注意这里不能获取值，因为这里还没有加锁，很有可能陷入死循环
        int expectNum ;
        while (!compareAndSwap(expectNum = getNum(), expectNum + 1)) {
        }
    }

    public static int getNum() {
        return num;
    }

    /**
     * CAS思想：将预期值和当前最新值比较，如果相同则交换，否则返回false
     * 这里真正的只是锁了第三步
     * @parm expectCount  期望值
     * @parm newCount 最新的值
     */
    public static synchronized boolean compareAndSwap(int expectCount, int newCount) {
        if (expectCount == getNum()) {
            num = newCount;
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    for (int j = 0; j < 100; j++) {
                        request();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    c.countDown();
                }
            }).start();
        }
        c.await();
        System.out.println(num);
    }
}
