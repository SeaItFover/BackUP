package others;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("111");
        list.add("222");
        list.add("222");
        list.add("333");
        list.add("444");
        list.add("555");
        list.add("666");
        ListIterator it = list.listIterator();
        while (it.hasNext()){

            if (it.next().equals("222")){
                it.remove();
            }
        }
        System.out.println(list);


    }
}
