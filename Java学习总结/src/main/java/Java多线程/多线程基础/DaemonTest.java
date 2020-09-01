package Java多线程.多线程基础;

/**
 * 设置指定线程为守护线程（jvm停止不需要等待守护线程执行完毕，
 * 但是jvm一旦终止了，守护线程也停止了，只是说jvm停止要等待用户线程执行完毕，
 * 但不需要等守护线程执行完毕
 *
 * 守护线程就一句语法：t1.setDaemon(true);就可以将t1线程指定为守护线程，默认的Daemon是false；
 */

public class DaemonTest {
    public static void main(String[] args) {
        God god = new God();
        Thread t1 = new Thread(god);
        t1.setDaemon(true);
        Thread t2 = new Thread(new You());
        t1.start();
        t2.start();

    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i< 365*1; i++){
            System.out.println("zhongjiang");
        }
    }
}

class God implements Runnable{
    @Override
    public void run() {
        for (;true;){
            System.out.println("God bless you!");
        }
    }
}


