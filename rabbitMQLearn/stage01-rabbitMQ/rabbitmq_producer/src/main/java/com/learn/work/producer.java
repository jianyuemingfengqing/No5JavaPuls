package com.learn.work;

import com.learn.utils.RabbitMQConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class producer {
    // 发送消息
    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitMQConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        String queueName = "rabbitmq-work-queue";
        channel.queueDeclare(queueName, true, false, false, null);

        for (int i = 0; i < 10; i++) {
            String message = "niHao" + i;
            channel.basicPublish("", queueName, null, message.getBytes());
        }


        channel.close();
        connection.close();
    }
}
