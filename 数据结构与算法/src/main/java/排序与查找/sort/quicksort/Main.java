
package 排序与查找.sort.quicksort;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 2, 7, 4, 5};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int standard = arr[start];
            int low = start;
            int high = end;

            while (low < high) {
                while (low < high && arr[high] >= standard){
                    high--;
                }
                arr[low] = arr[high];
                while (low < high && arr[low] <= standard) {
                    low++;
                }
                arr[high] = arr[low];

            }
            arr[low] = standard;
            quickSort(arr, start, low);
            quickSort(arr, low + 1, end);
        }


    }
}
/*
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] ast = new String[]{"","aaa","bcd","zzz"};
//        System.out.println(Arrays.toString(ast));


//        System.out.println();
//        System.out.println(longest());
    }

    public static int longest(){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        int i = 0;
        sc.nextLine();
        while (i < n && sc.hasNextLine()){

            strings[i++] = sc.nextLine();

        }
        sc.close();
        System.out.println(Arrays.toString(strings));
        int ret = 0;
        int k = 0;
        char l = 0;
        char r = 0;
//        Arrays.sort(strings);
//        System.out.println(Arrays.toString(strings));
        while (k < strings.length){
            Arrays.sort(strings,k,strings.length-1);
            System.out.println(k);
            l = strings[k].charAt(0);
            if (l>=r){
                ret+=strings[k].length();
                r = strings[k].charAt(strings[k].length()-1);
            }
            k++;

        }

        return ret;
    }
}
*/
