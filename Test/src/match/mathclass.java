package match;

/**
 * 对于整型除法运算中向上取整，不要使用math类中的ceil。
 */
public class mathclass {
    public static void main(String[] args) {
        System.out.println(Math.ceil(23 / 10));
        System.out.println((20.1 / 10));
        int s = 0;
        s += (20.6 + 10 -1 ) / 10;
        System.out.println(s);
        System.out.println((int)((21 + 10 -1 ) / 10));
    }
}
