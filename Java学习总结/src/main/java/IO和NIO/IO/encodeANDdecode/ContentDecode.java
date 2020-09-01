package IO和NIO.IO.encodeANDdecode;

import java.io.UnsupportedEncodingException;

/**
 * 解码：字节-->字符串
 */
public class ContentDecode {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String msg = "性命生命使命a";
        byte[] datas = msg.getBytes     ();//默认使用工程的字符集（

        //public StringClass(byte bytes[], int offset, int length, Charset charset)
        msg = new String(datas);
        System.out.println(msg);

        //乱码
        //1.字节数不够
        msg = new String(datas,0,datas.length-2,"utf8");
        System.out.println(msg);
        msg = new String(datas,0,datas.length,"utf8");
        System.out.println(msg);

        //2.字符集不统一
        msg = new String(datas,0,datas.length,"UTF-16");
        System.out.println(msg);
    }
}
