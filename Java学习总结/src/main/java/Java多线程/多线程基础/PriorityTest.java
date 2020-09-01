package Java多线程.多线程基础;

/**
 * 在学完Java面向对象之后，剩下的内容基本上是在学习以及练习API
 * 比如线程的优先级这一块内容，其实只是一个语法的问题，t1.setPriority(1);
 * 优先级分为1-10
 * MIN_PRIORITY = 1;
 * NORM_PRIORITY = 5;
 * MAX_PRIORITY = 10;
 */
public class PriorityTest {

    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for(int i =1; i< 200; i++){
                System.out.println("i=" + i);
            }

        } );
        t1.setPriority(0);   //throws exception
        t1.start();

        Thread t2 = new Thread(()-> {
            for(int j = 1; j< 200; j++){
                System.out.println("j = " +j);
            }
        });
        t2.setPriority(10);
        t2.start();
    }
}
