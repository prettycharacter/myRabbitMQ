package com.ampq.myrabbitmq.work;

import com.ampq.myrabbitmq.utils.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * @author xpf
 * @date 2020/5/14 14:28
 */
public class Consumer {
    private final static String QUEUE_NAME = "q_test_2";

    public static void main(String[] args) throws Exception {
        //获取连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        //创建通道
        Channel channel = connection.createChannel();
        //创建队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        //同一时刻服务器只会发送一条消息
        channel.basicQos(1);
        //获取消息
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "utf-8");
                //表示使用手动确认模式
                System.out.println("[Receive]：" + message);
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            }
        };
        //监听队列，false表示手动返回完成状态，true表示自动
        channel.basicConsume(QUEUE_NAME,false,consumer);

    }
}
