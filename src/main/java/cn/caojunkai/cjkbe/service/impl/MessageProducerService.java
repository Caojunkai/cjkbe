/* Created by Fitz on 2016/12/23 */

package cn.caojunkai.cjkbe.service.impl;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {
    @Autowired
    private AmqpAdmin amqpAdmin;
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private ConnectionFactory connectionFactory;

    public void pushToMessageQueue(String routingKey, String message) {
        amqpTemplate.convertAndSend(routingKey, message);
        System.out.println("成功插入消息 " + message);
    }

    public void popMessage(String destinationQueueName) {
        Message message = amqpTemplate.receive(destinationQueueName);
        System.out.println("成功取出消息 " + new String(message.getBody()));
    }

}
