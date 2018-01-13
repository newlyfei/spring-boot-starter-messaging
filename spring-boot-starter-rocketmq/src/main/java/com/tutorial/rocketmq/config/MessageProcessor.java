package com.tutorial.rocketmq.config;

import org.apache.rocketmq.common.message.MessageExt;

public interface MessageProcessor {
    /**
     * 处理消息的接口
     * @param messageExt
     * @return
     */
    boolean handleMessage(MessageExt messageExt);
}
