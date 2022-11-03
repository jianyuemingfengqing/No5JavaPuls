package com.learn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringRMQTest {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Test
    public void simpleTest() {
        String message = "Hello";
        rabbitTemplate.convertAndSend("","spring-simple-queue",message);
    }

    @Test
    public void workerTest(){
        for (int i = 1; i <= 10; i++) {
            String message = "Hello"+i;
            rabbitTemplate.convertAndSend("","spring-worker-queue",message);
        }
    }

    @Test
    public void fanoutTest() {
        String message = "Hello";
        rabbitTemplate.convertAndSend("exchange-fanout","",message);
    }
    @Test
    public void directTest() {
        String message = "Hello";
        rabbitTemplate.convertAndSend("exchange-direct","spring2",message);
    }
    @Test
    public void topicTest() {
        String message = "Hello";
        rabbitTemplate.convertAndSend("exchange-topic","topic.f",message);
    }
}
