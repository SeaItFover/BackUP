package Java多线程.synchronize.ThreeSafeExamples;

import java.util.ArrayList;
import java.util.List;

public class SynBlock02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i<10000; i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try{
            Thread.sleep(2000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
