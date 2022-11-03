package com.learn.listener.fanout;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RMQFanoutListener2 implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println("consumer2: " + new String(message.getBody()));
    }
}
