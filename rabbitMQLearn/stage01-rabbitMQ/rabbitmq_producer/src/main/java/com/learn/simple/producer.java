package com.learn.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class producer {
    // 发送消息
    public static void main(String[] args) throws IOException, TimeoutException {
        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.144.130");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("admin");
        connectionFactory.setVirtualHost("myhost");

        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();

        String queueName = "rabbitmq-simple-queue";
        channel.queueDeclare(queueName,true,false,false,null);

        String message = "niHao";
        channel.basicPublish("",queueName,null,message.getBytes());

        channel.close();
        connection.close();
    }
}
