package com.tutorial.redis;

import com.tutorial.App;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

@SpringBootApplication
public class JedisSubscribe {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class,args);
        JedisPool jedisPool=context.getBean(JedisPool.class);
        Jedis jedis=jedisPool.getResource();
        JedisPubSub jedisPubSub=new JedisPubSub() {
            @Override
            public void onMessage(String channel, String message) {
                super.onMessage(channel, message);
            }

        };

        /**
         * subscribe是一个阻塞的方法，在取消订阅该频道前，会一直阻塞在这，
         * 只有当取消了订阅才会执行下面的other code，参考上面代码，
         * 在onMessage里面收到消息后，调用this.unsubscribe();来取消订阅
         * 这样才会执行后面的other code
         */
        jedis.subscribe(jedisPubSub,"redisTopic1");

        System.out.println("-- Not be executed  --");
    }
}
