package Java多线程.生产者消费者模式;

/**
 * 生产者消费者初始版本02
 * if语句判断交互，四个线程操作资源类；//出错
 * 总结：多线程交互中，判断语句用while，这是为了防止虚假唤醒
 */
//线程操作资源类，先建立一个资源类
class AirCondition02{
    private int num = 0;
    public synchronized void increment() throws InterruptedException {
        while (num != 0){
            this.wait();
        }
        //num++;
        System.out.println(Thread.currentThread().getName() + ++num);
        this.notifyAll();
    }
    public synchronized void decrement() throws InterruptedException {
        while (num == 0){
            this.wait();
        }
        num--;
        System.out.println(Thread.currentThread().getName()+num);
        this.notifyAll();
    }
}

public class ProduceConsumer02 {
    public static void main(String[] args) {
        AirCondition02 air = new AirCondition02();

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
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                try {
                    air.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"C").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++){
                try {
                    air.decrement();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}
