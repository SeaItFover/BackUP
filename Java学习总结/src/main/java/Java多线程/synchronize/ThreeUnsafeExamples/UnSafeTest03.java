package Java多线程.synchronize.ThreeUnsafeExamples;

import java.util.ArrayList;
import java.util.List;

public class UnSafeTest03 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        new Thread(()->{
            for (int i = 0; i<30000; i++){
                new Thread(()->{

                        list.add(Thread.currentThread().getName());
                }).start();
            }
        }).start();

        try{
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(list.size());
        System.out.println("一共花费了："+(end-start));
    }
}
