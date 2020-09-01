package Java多线程.高频面试点.volatile关键字;

/**
 * 由于JMM规范，线程与线程之间的变量是不可见的
 */
public class 可见性问题 {

    private  static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num == 0){

            }
        }).start();

        Thread.sleep(2000);
        num = 1;
    }
}
