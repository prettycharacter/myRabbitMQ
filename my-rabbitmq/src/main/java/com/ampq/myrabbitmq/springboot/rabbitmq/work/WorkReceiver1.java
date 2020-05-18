package com.ampq.myrabbitmq.springboot.rabbitmq.work;

import com.ampq.myrabbitmq.utils.Constants;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xpf
 * @date 2020/5/18 10:20
 */
@Component
@RabbitListener(queues = Constants.BOOT_QUEUE_WORK, containerFactory = "workListenerFactory")
public class WorkReceiver1 {

    @RabbitHandler
    public void process(String hello) throws Exception {
        Thread.sleep(10);
        Constants.RECEIVE_1++;
        //接收消息
        System.out.println("receiver1:" + hello + " " + Constants.RECEIVE_1);
    }
}
