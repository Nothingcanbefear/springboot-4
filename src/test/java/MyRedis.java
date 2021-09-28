import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class MyRedis {
    public static void main(String[] args) {

        Jedis js = new Jedis("127.0.0.1", 6379);
            js.set("k3","v3");
//        js.append("2","22");
//        HashMap<String, String> map = new HashMap<>();
//        map.put("v1","kkkk1");
//        js.hmset("ma",map);
//        js.set("chain","中文");
//        js.lset("lset1",1,"222");
        System.out.println(js.dump("k3"));
//        System.out.println(js.get("chain"));
//        Math.random()
    }
}
