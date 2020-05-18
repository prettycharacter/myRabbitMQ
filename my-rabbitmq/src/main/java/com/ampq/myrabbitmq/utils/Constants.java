package com.ampq.myrabbitmq.utils;

/**
 * @author xpf
 * @date 2020/5/18 14:13
 */
public class Constants {
    //简单模式队列名称
    public final static String BOOT_QUEUE_SIMPLE = "boot_queue_simple";
    //work模式队列名称
    public final static String BOOT_QUEUE_WORK = "boot_queue_work";
    //计算能者多劳接收的数量
    public static int RECEIVE_1 = 0;
    public static int RECEIVE_2 = 0;

    //订阅模式
   //队列
    public final static String A_BOOT_QUEUE_PUBLISH = "a_boot_queue_publish";
    public final static String B_BOOT_QUEUE_PUBLISH = "b_boot_queue_publish";
    public final static String C_BOOT_QUEUE_PUBLISH = "c_boot_queue_publish";
    //交换机
    public final static String BOOT_EXCHANGE_PUBLISH = "boot_exchange_publish";

   //topic模式
   //队列
   public final static String BOOT_QUEUE_TOPIC_A = "boot_queue_topic_a";
   public final static String BOOT_QUEUE_TOPIC_B = "boot_queue_topic_b";
   //交换机
   public final static String BOOT_EXCHANGE_TOPIC = "boot_exchange_topic";


}
