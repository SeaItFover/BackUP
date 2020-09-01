package leetcode.算法思想.双指针;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Print {
    private int num = 0;
    private int count = 1;
    private char countchar = 'A';
    Lock lock = new ReentrantLock();
    Condition c1 = lock.newCondition();
    Condition c2 = lock.newCondition();

    public void printNum() {
        lock.lock();
        if (num != 0) {
            try {
                c1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.print(count++);
        num = 1;
        c2.signal();
        try {

        } finally {
            lock.unlock();
        }
    }

    public void printChar() {
        lock.lock();

        try {
            if (num == 0) {
                try {
                    c2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.print((char)countchar);
            countchar =(char)(countchar +1) ;
            num = 0;
            c1.signal();
        } finally {
            lock.unlock();
        }
    }
}

public class NumCharDemo {

    public static void main(String[] args) {
        System.out.println('a'+1);
        Print p = new Print();

        new Thread(()->{
            for (int i = 0; i < 26; i++){

                p.printNum();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 26; i++){

                p.printChar();
            }
        }).start();
    }
}
