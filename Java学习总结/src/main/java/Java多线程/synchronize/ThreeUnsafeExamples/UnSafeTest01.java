package Java多线程.synchronize.ThreeUnsafeExamples;

/**
 * 数据有负数、有重复
 * 有负数是因为
 */
public class UnSafeTest01 {
    public static void main(String[] args) {
        UnSafeWeb12306 unSafe01 = new UnSafeWeb12306();
        new Thread(unSafe01,"1").start();
        new Thread(unSafe01,"2").start();
        new Thread(unSafe01,"3").start();
    }

}

class UnSafeWeb12306 implements Runnable{
    private static int ticketNums = 10;
    private static boolean flag = true;

    @Override
    public void run() {
        while (flag){
            test();

        }
    }

    public static void test(){
        if (ticketNums < 0){
            flag = false;
            return;
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"-->"+ticketNums--);

    }
}
