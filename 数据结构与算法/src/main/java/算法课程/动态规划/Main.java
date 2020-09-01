package 算法课程.动态规划;


import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> ret = new ArrayList<>();
        while(sc.hasNext()){
            ret.add(sc.next());
        }
        sc.close();
        ArrayList<String> strings = new ArrayList<>();
        String[] map = { "surprise", "happy", "ctrip", "travel", "wellcome","student","system","program","editor"};
        for (int i = 0; i < ret.size(); i++){
            for (int j = 0; j < map.length; j++){
                if (isEqu(ret.get(i),map[j]) <= 2){
                    strings.add(map[j]);
                    break;
                }
            }

        }
        if (strings.size() == 0) {
            strings.add(null);
        }
        for (int i = 0; i < strings.size(); i++){
            System.out.println(strings.get(i));

        }
    }

    private static int isEqu(String s, String s1) {
        int[][] ret = new int[s.length() + 1][s1.length() +1];
        for (int i = 0; i <= s.length(); i++){
            ret[i][0] = i;
        }
        for (int i = 0; i <= s1.length(); i++){
            ret[0][i] = i;

        }
        for (int i = 1; i <= s.length(); i++){
            for (int j = 1; j <= s1.length(); j++){
                if (s.charAt(i-1) == s1.charAt(j-1)){
                    ret[i][j] = ret[i-1][j-1];
                }else {
                    ret[i][j] = Math.min(ret[i-1][j],Math.min(ret[i][j-1],ret[i-1][j-1])) + 1;
                }

            }
        }
        return ret[s.length()][s1.length()];
    }


}
