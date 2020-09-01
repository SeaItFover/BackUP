package Java多线程.多线程基础.三个工具类;

//尝试用标志位去模拟countDOwnlatch
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        boolean[] live = new boolean[6];
        for (boolean l : live) {
            l = true;
        }
        for (int i = 0; i < 6; i++) {
            final int j = i;
            new Thread(() -> {
                System.out.println("第" + j + "个同学离开教室");
            }, String.valueOf(i)).start();
        }

        Thread.sleep(4000);
//        for (int i =0;i<6;i++){
//            if (String.valueOf(i).isAlive()){
//                live[i] = false;
//            }
//        }
        if ((live[0] | live[1] | live[2] | live[3] | live[4] | live[5]) == false) {
            System.out.println("班长离开教室！");
        }
    }
}

