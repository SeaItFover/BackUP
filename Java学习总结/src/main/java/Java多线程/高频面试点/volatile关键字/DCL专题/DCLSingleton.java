package Java多线程.高频面试点.volatile关键字.DCL专题;

import org.omg.CORBA.TIMEOUT;
import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.TimeUnit;

/**
 * 双重检测单例模式是懒汉式单例中多线程的版本。
 *
 * 下面案例有问题：可能导致指令重排序。
 */
public class DCLSingleton {

    private static volatile DCLSingleton instance;
    public static int i = 2;

    private DCLSingleton() {}

    public static DCLSingleton getInstance() throws InterruptedException {
        if (instance == null){
            synchronized (DCLSingleton.class){
                if (instance == null){
                    //TimeUnit.MILLISECONDS.sleep(1000)
                    Thread.sleep(1000);
                    instance = new DCLSingleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++){
            new Thread(() -> {
                DCLSingleton instance = null;
                try {
                    instance = DCLSingleton.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(instance);
            }).start();
        }

        while (Thread.activeCount() > 2){
            Thread.yield();
        }
    }
}
