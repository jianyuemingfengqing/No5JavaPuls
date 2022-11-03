package com.learn.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations="classpath:spring.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SRMConsumerTest {
    @Test
    public void simpleConsumerTest(){
        while (true){

        }
    }
}
