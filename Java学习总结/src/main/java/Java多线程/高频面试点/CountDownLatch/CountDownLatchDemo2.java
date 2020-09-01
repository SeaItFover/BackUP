package Java多线程.高频面试点.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo2 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(10);

        for (int i = 0; i < 10; i++) {
            new Thread(new Worker(i, startSignal, doneSignal)).start();
        }

        TimeUnit.MILLISECONDS.sleep(500);

        System.out.println("子任务栅栏已开启");
        startSignal.countDown();

        System.out.println("等待子任务结束");
        long startTime = System.currentTimeMillis();
        doneSignal.await();
        long endTime = System.currentTimeMillis();
        System.out.println("所有子任务已经运行结束，耗时：" + (endTime - startTime));
    }

    static class Worker implements Runnable{
        private int id;
        private CountDownLatch startSignal;
        private CountDownLatch doneSignal;

        public Worker(int id, CountDownLatch startSignal, CountDownLatch doneSignal) {
            this.id = id;
            this.startSignal = startSignal;
            this.doneSignal = doneSignal;
        }


        @Override
        public void run() {
            try {
                startSignal.await();
                System.out.println("Thread id: " + id + "，开启时间" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                doneSignal.countDown();
            }
        }
    }
}
