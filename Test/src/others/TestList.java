package others;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestList {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(-2 % 5);
        List<Integer> graph = new ArrayList<>();

        for (int i = 0; i < 200; i++){
            final int j = i;
            new Thread(() -> {
                System.out.println(graph);
                graph.add(j);
            }).start();
        }
        Thread.sleep(2000);
        System.out.println(graph.size());
        System.out.println(graph);
    }
}
