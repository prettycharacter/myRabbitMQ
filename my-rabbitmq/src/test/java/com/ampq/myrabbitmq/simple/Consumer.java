package com.ampq.myrabbitmq.simple;

import com.ampq.myrabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author xpf
 * @date 2020/5/14 14:28
 */
public class Consumer {
    private final static String QUEUE_NAME = "q_test_1";

    public static void main(String[] args) throws Exception {
        //获取连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //创建队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //获取消息
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "utf-8");
                System.out.println("[Receive]：" + message);
            }
        };
        channel.basicConsume(QUEUE_NAME, consumer);
    }
}
