package com.learn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class ProducerTest {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    public void confirmTest() {
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                //ack  确认
                if (ack) {
                    System.out.println("连接交换机成功");
                } else {
                    System.out.println("错误原因 " + cause);
                }
            }
        });

        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returned) {
                System.out.println("退回的消息   " + new String(returned.getMessage().getBody()));
                System.out.println("错误代码   " + returned.getReplyCode());
                System.out.println("错误原因   " + returned.getReplyText());
            }
        });

//        rabbitTemplate.convertAndSend("confirm-exchange", "confirm", "test confirm  测试");
        rabbitTemplate.convertAndSend("confirm-exchange", "confirm2", "test confirm  测试");
    }
}
