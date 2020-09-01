package 基本数据结构的实现.图;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;

/**
 * 输入：10 6
 * 10代表下面的6行字符串长度为10
 * 按照度量将他们排序并输出
 *
 * 特例：如果是相同的，怎么办
 */
class DNA implements Comparable{

    String value;
    int leval;

    public String getValue() {
        return value;
    }

    public DNA(String value){
        this.value = value;
        this.leval = numsDu(value);
    }
    @Override
    public int compareTo(Object o) {
        DNA obj = (DNA)o;
        return this.leval -obj.leval;
    }

    public int numsDu(String msg){
        int i,j,res =0;
        for (i = 0; i < msg.length(); i++){
            for (j = i+1; j< msg.length(); j++){
                if (msg.charAt(i) > msg.charAt(j)){
                    res++;
                }
            }
        }
        return res;
    }
}

public class SortingOfDNA {

    public static void main(String[] args) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(System.in));
        String row1 = dataInputStream.readLine();
        String[] row = row1.split(" ");
        int m = Integer.valueOf(row[0]);
        int n = Integer.valueOf(row[1]);
        DNA[] dnas = new DNA[n];
        for (int i = 0; i < n; i++){
            dnas[i] = new DNA(dataInputStream.readLine());
        }
        Arrays.sort(dnas);
        for(DNA data:dnas){
            System.out.println(data.value);
        }
    }
}
