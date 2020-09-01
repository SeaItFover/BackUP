package Java虚拟机;

import java.util.Arrays;
import java.util.List;

public class MyProject{
    public static native int sss();
    public static void main(String[] args){
        System.out.println(sss());

        Object o = new Object();
        List list = Arrays.asList(1,2,3);
        System.out.println(list);
        list.forEach(System.out::println);
        //System.out.println(o.getClass().getClassLoader().getParent().getParent());
        //System.out.println(o.getClass().getClassLoader().getParent());
        System.out.println(o.getClass().getClassLoader());

        MyProject mp = new MyProject();
        System.out.println(mp.getClass().getClassLoader().getParent().getParent());
        System.out.println(mp.getClass().getClassLoader().getParent());
        System.out.println(mp.getClass().getClassLoader());
    }
}