package com.ampq.myrabbitmq.utils;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * @author xpf
 * @date 2020/5/14 14:35
 */
public class ConnectionUtil {
    public static Connection getConnection() throws Exception {
        //定义连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        //设置服务地址
        factory.setHost("localhost");
        //端口
        factory.setPort(5672);
        //设置账号信息，用户名、密码、vhost
        factory.setVirtualHost("/");
        factory.setUsername("mqadmin");
        factory.setPassword("mqadmin123");
        // 通过工程获取连接
        Connection connection = factory.newConnection();
        return connection;
    }

}
