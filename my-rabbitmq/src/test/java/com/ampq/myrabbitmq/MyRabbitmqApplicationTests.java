package com.ampq.myrabbitmq;

import com.ampq.myrabbitmq.springboot.rabbitmq.publish.PublishSender;
import com.ampq.myrabbitmq.springboot.rabbitmq.simple.SimpleSender;
import com.ampq.myrabbitmq.springboot.rabbitmq.topic.TopicSender;
import com.ampq.myrabbitmq.springboot.rabbitmq.work.WorkSender;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MyRabbitmqApplicationTests {
    @Resource
    private SimpleSender simpleSender;
    @Resource
    private WorkSender workSender;
    @Resource
    private PublishSender publishSender;
    @Resource
    private TopicSender topicSender;

    /**
     * 简单模式测试
     */
    @Test
    void simpleQueue() {
        simpleSender.send();
    }

    /**
     * work模式测试
     */
    @Test
    void workQueue() throws Exception {
        for (int i = 0; i < 100; i++) {
            workSender.send(i);
        }
    }

    /**
     * 订阅模式测试
     */
    @Test
    void PublishQueue() throws Exception {
        publishSender.send();
    }

    /**
     * topic模式测试
     */
    @Test
    void TopicQueue() throws Exception {
        topicSender.send1();
        topicSender.send2();
    }

}
