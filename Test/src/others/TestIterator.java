package others;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TestIterator {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        ListIterator<Integer> it = list.listIterator();
        for (int i = 0; i < 300; i++){
            final int j = i;
            new Thread(() -> {
                it.add(j);
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(list.size());
        System.out.println(list);
    }
}
