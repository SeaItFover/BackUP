package 实习笔试题.秋招.网易;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class test {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int[] ints = {1, 2, 3, 4, 5};
        String collect1 = Arrays.stream(ints).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(collect1);

        String collect = list.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}
