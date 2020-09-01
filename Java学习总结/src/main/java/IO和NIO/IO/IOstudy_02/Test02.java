package IO和NIO.IO.IOstudy_02;

import java.io.*;

public class Test02 {
    public static void main(String[] args) {
        File src = new File("D:\\JAVA\\Idea\\Project\\IO\\src/aaa.txt");
        OutputStream os = null;
        try {
            os = new FileOutputStream(src);
            for(int i = 0 ; i<50000; i++){
                if(i != 0 && i % 10 == 0){
                    os.write('\n');
                }
                os.write('a');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            os.flush();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
