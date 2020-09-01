package Java多线程.synchronize;

/**
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 */
public class SynTest01 {
    public static void main(String[] args) {
        SafeWeb12306 safeWeb12306 = new SafeWeb12306();
        new Thread(safeWeb12306,"1").start();
        new Thread(safeWeb12306,"2").start();
        new Thread(safeWeb12306,"3").start();
    }
}

class SafeWeb12306 implements Runnable{

    private int tickerNums = 100;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            //此处加了延时，影响的是什么
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            test();
        }
    }

    public synchronized void test(){
        if (tickerNums <= 0){
            flag = false;
            return;
        }

        System.out.println(Thread.currentThread().getName()+"-->"+tickerNums--);
    }
}