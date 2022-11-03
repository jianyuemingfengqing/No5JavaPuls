package com.learn.topic;

import com.learn.utils.RabbitMQConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = RabbitMQConnectionUtils.getConnection();

        Channel channel = connection.createChannel();

        String queueName = "rabbitmq-topic-queue2";

        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("consumer2: "+new String(body));
            }
        };

        channel.basicConsume(queueName, true, consumer);

    }
}
