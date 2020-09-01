package leetcode.数据结构.alibaba;

import java.util.concurrent.CountDownLatch;

/**
 * 老师您好，我的思路是这样的：
 * 首先题目的意思是必须三个游客都到了某个地点才能继续，所以我想到了使用countDownLatch
 * 题目有两个限制，所以我使用了两个栅栏来配合使用。
 */
public class Q4 {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch bLimit = new CountDownLatch(3);
        CountDownLatch dLimit = new CountDownLatch(3);

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("游客从A到B进行中");
                bLimit.countDown();
            }).start();
        }
        bLimit.await();

        System.out.println("游客全部集合到B");

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                System.out.println("游客往出口D进行中");
                dLimit.countDown();
            }).start();
        }
        dLimit.await();
        System.out.println("游客全部到达D，一起坐大巴");
    }

}

