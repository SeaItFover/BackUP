package 左神算法.贪心算法;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {

    public static class Program{
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static int bestArrange(Program[] programs, int cur) {
        Arrays.sort(programs, Comparator.comparingInt(p -> p.end));
        int res = 0;
        for (int i = 0; i < programs.length; i++) {
            if (cur <= programs[i].start) {
                res++;
                cur =  programs[i].end;
            }
        }
        return res;
    }
}
