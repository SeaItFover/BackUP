package Java多线程.synchronize.deadlock;

/**
 * 死锁：过多的同步可能造成相互不释放资源
 * 从而相互等待，一般发生于同步中持有多个对象的锁
 *
 * 避免：不要在同一个代码块中同时持有多个对象的锁
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0,"zhuzhu");
        Makeup g2 = new Makeup(1,"zhu");
        g1.start();
        g2.start();
    }
}

class LipStick{

}

class Mirror{

}

class Makeup extends Thread {
    static LipStick lipStick = new LipStick();
    static Mirror mirror = new Mirror();
    //选择
    int choice;
    //名字
    String girl;

    public Makeup(int choice,String girl){
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {
        makeup();
    }

    //相互持有对方的对象锁-->可能造成死锁
    private void makeup(){
        if (choice == 0){
            synchronized(lipStick){
                System.out.println(this.girl+"涂口红");
                //一秒后想拥有镜子的锁
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(mirror){
                    System.out.println(this.girl+"照镜子");
                }
            }
        }else {
            synchronized(mirror){
                System.out.println(this.girl+"照镜子");
                //一秒后想拥有口红的锁
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized(lipStick){
                    System.out.println(this.girl+"涂口红");
                }
            }
        }
    }
}