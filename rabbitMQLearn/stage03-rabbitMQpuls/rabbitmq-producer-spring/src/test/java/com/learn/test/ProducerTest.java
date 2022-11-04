package com.learn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
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
    public void confirmTest(){
    rabbitTemplate.convertAndSend("queue-confirm","confirm","test confirm  测试");
    }
}
