/* Created by Fitz on 2016/12/22 */

package cn.caojunkai.cjkbe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class EndPoint {
    protected Channel channel;
    protected Connection connection;
    protected String QUEUE_NAME;

    public EndPoint(String QUEUE_NAME) throws IOException {
        this.QUEUE_NAME = QUEUE_NAME;
        //Create a connection factory
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //hostname of your rabbitmq server
        connectionFactory.setHost("localhost");
        //getting a connection
        this.connection = connectionFactory.newConnection();
        //creating a channel
        this.channel = this.connection.createChannel();
        //declaring a queue for this channel. If queue does not exist,
        //it will be created on the server.
        channel.queueDeclare(this.QUEUE_NAME,false,false,false,null);
    }

    /**
     * 关闭channel和connection。并非必须，因为隐含是自动调用的。
     * @throws IOException
     */
    public void close() throws IOException{
        this.channel.close();
        this.connection.close();
    }
}
