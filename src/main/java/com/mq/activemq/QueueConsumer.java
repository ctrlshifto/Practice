package com.mq.activemq;

import cn.hutool.core.util.RandomUtil;
import com.util.ActiveMqUtil;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author WhomHim
 * @description 队列模式消费者
 * @date Create in 2019/5/13 11:22
 */
public class QueueConsumer {

    /**
     * 服务地址，端口默认61616
     */
    private static final String URL = "tcp://127.0.0.1:61616";

    /**
     * 这次消费的消息名称
     */
    private static final String QUEUE_NAME = "queue_style";

    /**
     * 消费者有可能是多个，为了区分不同的消费者，为其创建随机名称
     */
    private static final String consumerName = "consumer-" + RandomUtil.randomString(5);

    public static void main(String[] args) throws JMSException {
        //0. 先判断端口是否启动了 Active MQ 服务器
        ActiveMqUtil.checkServer();
        System.out.printf("%s 消费者启动了。 %n", consumerName);

        //1.创建ConnectiongFactory,绑定地址
        ConnectionFactory factory = new ActiveMQConnectionFactory(URL);
        //2.创建Connection
        Connection connection = factory.createConnection();
        //3.启动连接
        connection.start();
        //4.创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建一个目标 （队列类型）
        Destination destination = session.createQueue(QUEUE_NAME);
        //6.创建一个消费者
        MessageConsumer consumer = session.createConsumer(destination);
        //7.创建一个监听器
        consumer.setMessageListener(arg0 -> {
            TextMessage textMessage = (TextMessage) arg0;
            try {
                System.out.println(consumerName + " 接收消息：" + textMessage.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        });

        //8. 因为不知道什么时候有，所以没法主动关闭，就不关闭了，一直处于监听状态
        //connection.close();
    }
}
