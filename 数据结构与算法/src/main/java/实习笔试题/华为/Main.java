package 实习笔试题.华为;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
  2
  7
  PUSH 1
  PUSH 2
  TOP
  POP
  TOP
  POP
  POP
  5
  PUSH 1
  PUSH 2
  SIZE
  POP
  SIZE
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        System.out.println(Arrays.toString(s));
        String key = s[0];
        String strings = s[1];
        String[] ss = strings.split("],");
        int res = 0;
        ArrayList<String> list = new ArrayList<>();
        for (String s1 : ss) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s1.length(); i++){
                if (s1.charAt(i) != '['){
                    sb.append(s1.charAt(i));
                }else {
                    break;
                }
            }
            if (key.equals(sb.toString())){
                res++;
                StringBuilder temp = new StringBuilder();
                for (int i = 0; i < s1.length(); i++){
                    if (s1.charAt(i) == '='){
                        for (int j = i+1; j < s1.length(); j++){
                            if (s1.charAt(j) != ',' && s1.charAt(j) != ']'){
                                temp.append(s1.charAt(j));
                            }else{
                                i = j;
                                break;
                            }
                        }
                        temp.append(" ");
                    }
                }
                list.add(temp.toString());
            }

        }

        if (res == 0){
            System.out.println("FAIL");
        }

        for (String s1 : list) {
            System.out.println(s1);
        }
    }
}
