package com.jeesite.test;

import com.daxv.common.Bus.IBus;
import com.daxv.common.Queue.Bus;
import com.daxv.common.Queue.Config;
import com.daxv.common.Queue.QueueHandler;
import com.daxv.common.Queue.ReadQueueDao;

public class ReadMq {
	public static void main(String[] args) {

		new Thread(new Runnable() {
			 
			public void run() {
				new Bus(new Config("10.1.23.13", "daxu", "000000", "/"), new IBus() {					
					 
					public void doQueueHandle(QueueHandler queueManager) { 
						do {
							for (int i = 0; i < 10; i++) {
								queueManager.GetQueues("daxu", new ReadQueueDao() {
								 
									public void ReadQueue(String pushInfo) {
										try {
											System.out.println("读取到消息：" + pushInfo);
										} catch (Exception e) {
											// TODO: handle exception
										} 
									}
								});
							}
						} while (true);
			
					}
				}).Send();
			}
		}).start();
	}

}
