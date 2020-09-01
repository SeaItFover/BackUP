package IO和NIO.NIO.redis;

import redis.clients.jedis.Jedis;

public class Test {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.64.132", 6379);
        jedis.set("spy", "28");
        String spy = jedis.get("spy");
        System.out.println(spy);
    }
}
