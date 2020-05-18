package com.ampq.myrabbitmq.springboot.rabbitmq.publish;

import com.ampq.myrabbitmq.utils.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xpf
 * @date 2020/5/18 10:20
 */
@Component
@RabbitListener(queues = Constants.A_BOOT_QUEUE_PUBLISH)
public class PublishReceiver1 {

    @RabbitHandler
    public void process(String hello) throws Exception {
        //接收消息
        System.out.println("receiver1:" + hello);
    }
}
