package Java虚拟机;

import java.util.ArrayList;
import java.util.List;

public class HeapOver {
    public Object[] o = new Object[1024*1000];

    public static void main(String[] args) {
        List<HeapOver> list = new ArrayList<>();
        while (true){
            list.add(new HeapOver());
        }
    }
}
