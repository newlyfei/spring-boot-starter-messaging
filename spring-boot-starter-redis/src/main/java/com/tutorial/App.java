package com.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App {
    private static final Logger logger= LoggerFactory.getLogger(App.class);

    public static void main( String[] args ){
        ApplicationContext context = SpringApplication.run(App.class,args);
        JedisPool jedisPool=context.getBean(JedisPool.class);
        String uuid = UUID.randomUUID().toString();
        logger.info("jedisPool uuid : " + uuid);
        try (Jedis jedis = jedisPool.getResource()) {
//            jedis.setex(uuid, 1000, user.getUsername());
        }
    }
}
