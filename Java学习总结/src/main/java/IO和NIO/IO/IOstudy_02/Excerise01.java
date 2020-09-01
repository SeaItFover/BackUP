package IO和NIO.IO.IOstudy_02;

import java.io.*;

public class Excerise01 {
    public static void main(String[] args) {
        File src = new File("abc.txt");
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            int temp;
            while ((temp = is.read()) != -1){
                System.err.println((char)temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
