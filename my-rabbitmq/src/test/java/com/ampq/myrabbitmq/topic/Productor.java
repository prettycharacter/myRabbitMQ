package com.ampq.myrabbitmq.topic;

import com.ampq.myrabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author xpf
 * @date 2020/5/14 14:28
 */
public class Productor {
    private final static String EXCHANGE_NAME = "exchange_topic_1";

    public static void main(String[] args) throws Exception {
        //获取连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        //从连接中创建通道
        Channel channel = connection.createChannel();
        //声明交换机(exchange),direct为交换机类型。
        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
        //消息内容
        String message = "Hello World";
        //消息key为 routingtest
        channel.basicPublish(EXCHANGE_NAME,"topic.notice.all",  null, message.getBytes());
        System.out.println("send:" + message);
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
