package Java多线程.高频面试点.多线程下安全的集合;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class 集合线程不安全 {
    public static void main(String[] args) throws InterruptedException {
//        listTest();
//        setTest();
        mapTest();
        List<Integer> list = Arrays.asList(1,3,4);
        System.out.println(list);

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);

        Map<Integer,String> map = new HashMap<>();
        map.put(1,"1");
        map.put(2,"1");
        map.put(3,"1");
        System.out.println(map);


        Thread t = new Thread(()->{

        });
        t.start();
        System.out.println(t.isAlive());
        System.out.println("sss");
        //Thread.sleep(2000);
        System.out.println(t.isAlive());
    }

    public static void listTest(){
        List list = new ArrayList();
        for (int i = 0; i < 30; i++){
            final int j = i;
            new Thread(()->{
                list.add(j);
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }

    public static void setTest(){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 3; i++){
            final int j = i;
            new Thread(()->{
                set.add(String.valueOf(j));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    public static void mapTest(){
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 30; i++){
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }
}
