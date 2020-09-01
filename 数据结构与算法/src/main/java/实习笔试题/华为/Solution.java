package 实习笔试题.华为;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        System.out.println(ming());
    }

    public static String ming() {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.next().split(",");
        if (strings.length >= 100 || strings.length == 0) {
            return "error.0001";
        }
        for (String string : strings) {
            if (!Character.isUpperCase(string.charAt(0))) {
                return "error.0001";
            }
            for (int i = 0; i < string.length(); i++) {
                if (!Character.isLetter(string.charAt(i)) || !Character.isLowerCase(string.charAt(i))) {
                    return "error.0001";
                }
            }
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            if (map.containsKey(string)) {
                int t = map.get(string);
                map.put(string, t + 1);
            } else {
                map.put(string, 1);
            }
        }

        System.out.println(map);
        ArrayList<String> values = new ArrayList<>();
        Set<String> set = map.keySet();
        int max = 0;
        for (String s : set) {
            if (map.get(s) > max) {
                values.clear();
                values.add(s);
                max = map.get(s);
            } else if (map.get(s) == max) {
                values.add(s);
            }
        }
        System.out.println(values);
        Object[] objects = values.toArray();
        String[] res = new String[objects.length];
        for (int i = 0; i < objects.length; i++) {
            res[i] = String.valueOf(objects[i]);
        }
        Arrays.sort(res);
        return res[0];
    }
}
