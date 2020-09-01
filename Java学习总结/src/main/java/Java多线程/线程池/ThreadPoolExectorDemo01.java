package Java多线程.线程池;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExectorDemo01 {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,5,3L, TimeUnit.SECONDS,new LinkedBlockingQueue<>(3), Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());

        try{
            for (int i = 0; i < 9; i++){
                threadPoolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理业务！");
                });
            }
        }finally {
            threadPoolExecutor.shutdown();
        }

    }
}
