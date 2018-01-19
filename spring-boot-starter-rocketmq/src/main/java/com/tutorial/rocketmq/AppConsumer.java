package com.tutorial.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.exception.RemotingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class AppConsumer {
    private static final Logger logger= LoggerFactory.getLogger(AppConsumer.class);

    public static void main( String[] args ) throws InterruptedException, RemotingException, MQClientException, MQBrokerException {
        ApplicationContext context = SpringApplication.run(AppConsumer.class,args);
        DefaultMQPushConsumer consumer = context.getBean(DefaultMQPushConsumer.class);
    }
}
