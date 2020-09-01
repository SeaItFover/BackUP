package Java多线程.synchronize.ThreeSafeExamples;

public class SynBlock03 {
    public static void main(String[] args) {
        SynWeb123 synWeb123 = new SynWeb123();
        new Thread(synWeb123,"1").start();
        new Thread(synWeb123,"2").start();
        new Thread(synWeb123,"3").start();

    }
}

class SynWeb123 implements Runnable{
    private int ticketNums = 2000;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            test();
        }
    }

    public synchronized void test(){
        if (ticketNums <= 0){
            flag = false;
            return;
        }

        System.out.println(Thread.currentThread().getName() +"-->"+ ticketNums--);
    }
}
