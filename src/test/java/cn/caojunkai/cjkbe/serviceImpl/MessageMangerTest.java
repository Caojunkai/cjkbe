/* Created by Fitz on 2016/12/23 */

package cn.caojunkai.cjkbe.serviceImpl;

import cn.caojunkai.cjkbe.BaseTest;
import cn.caojunkai.cjkbe.service.impl.MessageConsumerService;
import cn.caojunkai.cjkbe.service.impl.MessageProducerService;
import org.junit.Test;

import javax.annotation.Resource;

public class MessageMangerTest extends BaseTest {
    @Resource
    private MessageProducerService messageProducerService;
    @Resource
    private MessageConsumerService messageConsumerService;

    @Test
    public void testMessageQueue(){
        messageProducerService.pushToMessageQueue("rabbit_queue_one", "hello giraffe");
//		messageProductorService.popMessage("rabbit_queue_one");
    }
}
