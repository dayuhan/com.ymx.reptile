package com.jeesite.test;

import java.util.Date;

import com.daxv.common.Bus.IBus;
import com.daxv.common.Bus.PushInfo;
import com.daxv.common.Queue.Bus;
import com.daxv.common.Queue.Config;
import com.daxv.common.Queue.QueueHandler;

public class WriteMq {
	public static void main(String[] args) {

		new Thread(new Runnable() {

			 
			public void run() {
				// TODO Auto-generated method stub
				new Bus(new Config("10.1.23.13", "daxu", "000000", "/"),
						new IBus() {
							 
							public void doQueueHandle(QueueHandler queueManager) {
								try {
									do {
										for (int i = 0; i < 20; i++) {
											PushInfo info = new PushInfo();
											info.setMessageBody("写入消息");
											info.setJpushTime(new Date());
											if (queueManager.AddProducerMQ(
													"daxu", info)) {
												System.out.println("写入消息");
											}
										}
										Thread.sleep(1000);
									} while (true);

								} catch (Exception e) {
								}
							}
						}).Send();
			}
		}).start();

	}
}
