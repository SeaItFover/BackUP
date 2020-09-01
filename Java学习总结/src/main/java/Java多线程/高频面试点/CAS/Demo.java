package Java多线程.高频面试点.CAS;

import java.util.concurrent.CountDownLatch;

/**
 * 模拟100个用户访问网站，每个用户访问10次，总计多少次。

 *
 */
public class Demo {
    //总访问量
    private static int num;

    //访问方法
    public static void request() throws InterruptedException {
        Thread.sleep(20);
        /**
         * 结果出错的原因：
         *      num++操作实际上是由三步来完成！（jvm执行引擎）
         *      1.获取num的值，记作A : A = num
         *      2.将A值加一，得到B：B = A + 1
         *      3.将B值赋给num
         * 解决的办法：
         *      加synchronized关键字或者ReentrantLock，虽然这样可以保证正确性，但是
         *      性能很差
         * 进一步优化的办法：
         *      程序中的
        */
        num++;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c = new CountDownLatch(100);
        for (int i = 0; i < 100; i++){
            new Thread(()->{
                try {
                    for (int j = 0; j < 100; j++){
                        request();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    c.countDown();
                }
            }).start();
        }
        c.await();
        System.out.println(num);
    }
}
