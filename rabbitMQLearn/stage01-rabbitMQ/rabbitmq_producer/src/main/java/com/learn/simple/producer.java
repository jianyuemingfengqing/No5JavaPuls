package com.learn.simple;

import com.learn.utils.RabbitMQConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class producer {
    // 发送消息
    public static void main(String[] args) throws IOException, TimeoutException {

        Connection connection = RabbitMQConnectionUtils.getConnection();
        Channel channel = connection.createChannel();

        String queueName = "rabbitmq-simple-queue";
        channel.queueDeclare(queueName, true, false, false, null);

        String message = "niHao";
        channel.basicPublish("", queueName, null, message.getBytes());

        channel.close();
        connection.close();
    }
}
