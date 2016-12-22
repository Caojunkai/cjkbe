/* Created by Fitz on 2016/12/22 */

package cn.caojunkai.cjkbe;

import java.util.HashMap;

public class Test {
    public Test() throws Exception{
        Consumer consumer = new Consumer("Hello");
        Thread comsumerThread = new Thread(consumer);
        comsumerThread.start();

        Send send = new Send("Hello");
        HashMap message = new HashMap();
        for (int i = 0; i < 1000; i++) {
            message.put("message number",i);
            send.sendMessage(message);
        }
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
    }
}
