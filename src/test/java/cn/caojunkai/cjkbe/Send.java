package cn.caojunkai.cjkbe;/* Created by Fitz on 2016/12/22 */

import org.apache.commons.lang.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;

public class Send extends EndPoint{
    public Send(String QUEUE_NAME) throws IOException {
        super(QUEUE_NAME);
    }
    public void sendMessage(Serializable object) throws IOException {
        this.channel.basicPublish("",this.QUEUE_NAME,null, SerializationUtils.serialize(object));
    }
}
