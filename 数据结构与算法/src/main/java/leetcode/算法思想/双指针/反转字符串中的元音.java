package leetcode.算法思想.双指针;

import java.util.Arrays;
import java.util.HashSet;

@SuppressWarnings("unchecked")
public class 反转字符串中的元音 {
    public final static HashSet vowels = new HashSet(Arrays.asList('a','e','i','o','u'));

    public static void main(String[] args) {
        String str = "leetcode";
        System.out.println(reversionString(str));
    }

//    public static String reversionString(String str){
//        char[] c = str.toCharArray();
//        char[] result = new char[c.length];
//        int i=0;
//        int j=c.length-1;
//        while (i <= j){
//            if (!vowels.contains(c[i])){
//                result[i++] = c[i];
//            }else if(!vowels.contains(c[j])){
//                result[j--] = c[j];
//            }else{
//                result[i] = c[j];
//                result[j] = c[i];
//                i++;
//                j--;
//            }
//        }
//        return new String(result);
//    }
public static String reversionString(String str){
    char[] result = new char[str.length()];
    int i=0;
    int j=str.length()-1;
    while (i <= j){
        char ci = str.charAt(i);
        char cj = str.charAt(j);
        if (!vowels.contains(ci)){
            result[i++] = ci;
        }else if(!vowels.contains(cj)){
            result[j--] = cj;
        }else{
            result[i++] = cj;
            result[j--] = ci;
        }
    }
    return new String(result);
}
}
