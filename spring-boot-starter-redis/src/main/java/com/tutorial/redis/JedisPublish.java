package com.tutorial.redis;

import com.tutorial.App;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPubSub;

@SpringBootApplication
public class JedisPublish {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context = SpringApplication.run(App.class,args);
        JedisPool jedisPool=context.getBean(JedisPool.class);
        Jedis jedis=jedisPool.getResource();
        jedis.publish("redisTopic1", "Hello Java");
        Thread.sleep(5000);
        jedis.publish("redisTopic1", "Hello Redis");
        Thread.sleep(5000);
        jedis.publish("redisTopic1", "Hello World");
    }
}
