package 左神算法;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestComparator {

    private int id;

    public static void main(String[] args) {
        /*User user1 = new User(1, "dsaf");
        User user2 = new User(2, "fads");
        User user3 = new User(3, "hgfdh");
        User user4 = new User(4, "eer");
        User user5 = new User(5, "kljjkl");
        User user6 = new User(6, "kljjkl");
        User user67 = new User(7, "kljjkl");

        User[] arr = new User[]{user1, user2, user3, user4, user5, user67,user6};
        //Arrays.sort(arr, Comparator.comparingInt(User :: getId).reversed());
        Arrays.sort(arr, Comparator.comparing(User::getName).reversed());
        //.thenComparing(User::getId));
        System.out.println(Arrays.toString(arr));*/


        List<String> list = Arrays.asList("nihao", "hello", "world", "welcome");
        list.sort(Comparator
                .comparingInt(String::length)
                .thenComparing(Comparator.comparing(String::toLowerCase)));
//        list.sort(Comparator.comparingInt(String::length)
//                .thenComparing(String::toLowerCase, Comparator.reverseOrder()));
        System.out.println(list);

    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class User {
        int id;
        String name;
    }
}



