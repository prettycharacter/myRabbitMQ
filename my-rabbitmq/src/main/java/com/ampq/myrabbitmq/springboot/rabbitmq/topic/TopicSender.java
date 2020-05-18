package com.ampq.myrabbitmq.springboot.rabbitmq.topic;

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
public class TopicSender {

    @Resource
    private AmqpTemplate rabbitTemplate;

    public void send1(){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String context = "topic1 : "+date;
        //简单队列情况下routingkey即为Q名
        this.rabbitTemplate.convertAndSend(Constants.BOOT_EXCHANGE_TOPIC,"topic.message.x.y",context);
    }
    public void send2(){
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        String context = "topic2 : "+date;
        //简单队列情况下routingkey即为Q名
        this.rabbitTemplate.convertAndSend(Constants.BOOT_EXCHANGE_TOPIC,"topic.message.x",context);
    }
}
