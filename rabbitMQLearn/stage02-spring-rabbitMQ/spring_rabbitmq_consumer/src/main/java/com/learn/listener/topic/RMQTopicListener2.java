package com.learn.listener.topic;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RMQTopicListener2 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("consumer2: topic " + new String(message.getBody()));
    }
}
