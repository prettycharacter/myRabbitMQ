package com.ampq.myrabbitmq.springboot.rabbitmq.simple;

import com.ampq.myrabbitmq.utils.Constants;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xpf
 * @date 2020/5/18 10:15
 */
@Component
public class SimpleSender {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String context = "hello "+date;
        System.out.println("sender :"+ context);
        //简单队列情况下routingkey即为Q名
        this.rabbitTemplate.convertAndSend(Constants.BOOT_QUEUE_SIMPLE,context);
    }
}
