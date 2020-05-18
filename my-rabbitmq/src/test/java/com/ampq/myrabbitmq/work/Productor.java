package com.ampq.myrabbitmq.work;

import com.ampq.myrabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * @author xpf
 * @date 2020/5/14 14:28
 */
public class Productor {
    private final static String QUEUE_NAME = "q_test_2";

    public static void main(String[] args) throws Exception {
        //获取连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        //从连接中创建通道
        Channel channel = connection.createChannel();
        //创建队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //消息内容
        for (int i = 0; i < 100; i++) {
            String message = "Hello World+" + i;
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
            System.out.println("send:" + message);
        }
        //关闭通道和连接
        channel.close();
        connection.close();
    }
}
