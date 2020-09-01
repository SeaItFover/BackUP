package Java多线程.高频面试点.CountDownLatch;

import java.util.concurrent.*;

public class CountDownLatchDemo1 {
    private static final int TASK_COUNT = 8;
    private static final int THREAD_SIZE = 10;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(TASK_COUNT);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(THREAD_SIZE , THREAD_SIZE, 2L, TimeUnit.NANOSECONDS, new LinkedBlockingQueue<>(THREAD_SIZE), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < TASK_COUNT; i++) {
            threadPoolExecutor.execute(new TaskRunnable(i, countDownLatch));
        }
        System.out.println("Main Thread is waiting!");
        countDownLatch.await();
        threadPoolExecutor.shutdown();
        System.out.println("Main Thread is finished");
    }

    static class TaskRunnable implements Runnable {
        private int taskId;
        private CountDownLatch latch;

        @Override
        public void run() {
            doWorker();
        }

        private void doWorker() {
            System.out.println("TaskId = " + taskId + "is executing");
            try {
                TimeUnit.SECONDS.sleep(5);
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("TaskId = " + taskId + "finished");
        }

        public TaskRunnable (int taskId, CountDownLatch latch) {
            this.taskId = taskId;
            this.latch = latch;
        }
    }

}
