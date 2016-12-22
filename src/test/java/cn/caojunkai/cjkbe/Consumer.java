/* Created by Fitz on 2016/12/22 */

package cn.caojunkai.cjkbe;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.util.Map;

public class Consumer extends EndPoint implements Runnable, com.rabbitmq.client.Consumer {

    public Consumer(String QUEUE_NAME) throws IOException {
        super(QUEUE_NAME);
    }

    /**
     * Called when consumer is registered.
     */
    public void handleConsumeOk(String s) {
        System.out.println("Consumer "+ s +" registered");
    }

    public void handleCancelOk(String s) {

    }

    public void handleCancel(String s) throws IOException {

    }

    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    public void handleRecoverOk(String s) {

    }

    /**
     * Called when new message is available.
     */
    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {
        Map map = (Map) SerializationUtils.deserialize(bytes);
        System.out.println("Message Number "+ map.get("message number") + " received.");
    }

    public void run() {
        try {
            this.channel.basicConsume(this.QUEUE_NAME, true, this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
