package others;

import java.util.*;

public class SavaTableData {
    public static void main(String[] args) {
        Map<String,Object> row1 = new HashMap<>();
        row1.put("grade",2);
        row1.put("name","jack");
        row1.put("gender","boy");

        Map row2 = new HashMap();
        row2.put("grade",1);
        row2.put("name","mary");
        row2.put("gender","girl");

        Map row3 = new HashMap();
        row3.put("grade",3);
        row3.put("name","nick");
        row3.put("gender","boy");

        List<Map<String,Object>> table = new ArrayList<>();
        table.add(row1);
        table.add(row2);
        table.add(row3);

        for (Map<String,Object> map:table) {
            Set<String> keys = map.keySet();
            for (String key:keys) {
                System.out.print(map.get(key)+"  ");
            }
            System.out.println();
        }

    }
}
