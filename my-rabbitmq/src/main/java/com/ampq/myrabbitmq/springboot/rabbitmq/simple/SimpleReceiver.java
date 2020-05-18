package com.ampq.myrabbitmq.springboot.rabbitmq.simple;

import com.ampq.myrabbitmq.utils.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xpf
 * @date 2020/5/18 10:20
 */
@Component
@RabbitListener(queues = Constants.BOOT_QUEUE_SIMPLE)
public class SimpleReceiver {

    @RabbitHandler
    public void process(String hello){
        //接收消息
        System.out.println("receiver:"+ hello);
    }
}
