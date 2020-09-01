package Java多线程.生产者消费者模式;

/**
 * 生产者消费者初始版本01
 * 使用synchronized关键字，if语句判断交互，两个线程操作资源类；
 */
//线程操作资源类，先建立一个资源类
class AirCondition{
    private int num = 0;
    public synchronized void increment() throws InterruptedException {
        if (num != 0){
            this.wait();
        }
        //num++;
        System.out.println(Thread.currentThread().getName() + ++num);
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        if (num == 0){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+"/t"+num);
        this.notifyAll();
    }
}

public class ProduceConsumer01 {
    public static void main(String[] args) {
        AirCondition air = new AirCondition();

        new Thread(()->{
            for (int i = 0; i < 10; i++){
                try {
                    air.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                try {
                    air.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"B").start();
    }
}
