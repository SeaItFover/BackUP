package Java多线程.高频面试点;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * 写一个容器，有size和add方法
 * new两个线程，一个线程添加10次对象，添加到5的时候，告诉另一个线程，并结束
 */
public class TestLockSupport {

    private static List<Object> list = new ArrayList<>();

    static Thread t1, t2;

    public static void add(Object o) {
        list.add(o);
    }

    public static int size() {
        return list.size();
    }

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                Object obj = new Object();
                list.add(obj);
                System.out.println("add " + i);
                if (list.size() == 5) {
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        });

        t2 = new Thread(() -> {
            //System.out.println("t2 start");
            LockSupport.park();
            System.out.println("t2 finish");
            LockSupport.unpark(t1);
        });

        t1.start();
        t2.start();
    }
}
