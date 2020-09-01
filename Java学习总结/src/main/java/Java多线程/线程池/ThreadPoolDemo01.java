package Java多线程.线程池;

import java.util.concurrent.*;

//体会线程池的使用方法
public class ThreadPoolDemo01 {
    public static void main(String[] args){
        ExecutorService es = Executors.newFixedThreadPool(5);
        BlockingQueue bq = new LinkedBlockingQueue();
        //模拟十个顾客来银行办理业务，但是银行只有五个窗口
        try{
            for (int i = 0; i < 10; i++){
                TimeUnit.MILLISECONDS.sleep(4000);
                es.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
                });
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            es.shutdown(); //等待线程池工作完毕再关闭线程池，否则会报错
        }

//        for (int i = 0; i<10;i++){
//            try{
//                es.execute(() -> {
//                    System.out.println(Thread.currentThread().getName()+"\t办理业务");
//                });
//            }finally {
//                es.shutdown();
//            }
//
//        }
    }
}
