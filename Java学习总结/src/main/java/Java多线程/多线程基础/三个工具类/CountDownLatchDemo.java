package Java多线程.多线程基础.三个工具类;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++){
            final int j = i;
            new Thread(()->{
                System.out.println("第"+j+"个同学离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println("班长走人");
    }
}
