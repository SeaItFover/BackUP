package Java集合类.HashMap.HashMap源码分析;

public class Test2 {
    public static void main(String[] args) {
        User u1 = new User(1001,"项羽","123");
        User u2 = new User(1002,"刘邦","123");
        Cart cart1 = new Cart();
        cart1.setUserId(u1.getId());
        Goods good1 = new Goods(10001,"万宝路",23);
        Goods good2 = new Goods(10001,"利群",23);
        Goods good3 = new Goods(10001,"",23);
        Goods good4 = new Goods(10001,"万宝路",23);
        Goods good5 = new Goods(10001,"万宝路",23);
    }
}
