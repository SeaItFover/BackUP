package IO和NIO.IO.IOstudy_02;
/**
 * outputStream
 * write
 */

import java.io.*;

public class IOTest04 {
    public static void main(String[] args) {
        File src = new File("wdnm.txt");
        try {
            src.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream os = null;
        try{
            os = new FileOutputStream(src,false);
            String msg = "IO is too easy";
            byte[] b = msg.getBytes();
            os.write(b,0,b.length);
            os.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        } finally{

        }

        if(os != null){
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
