package com.jeesite.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.daxv.common.Bus.IBus;
import com.daxv.common.Bus.PushInfo;
import com.daxv.common.Bus.PushTypeBase;
import com.daxv.common.Bus.PushTypeEnum;
import com.daxv.common.Http.HttpClient;
import com.daxv.common.Http.HttpDao;
import com.daxv.common.Queue.Bus;
import com.daxv.common.Queue.Config;
import com.daxv.common.Queue.Queue;
import com.daxv.common.Queue.QueueHandler;
import com.daxv.common.Queue.ReadQueueDao;
import com.daxv.common.ServerSocket.Message;
import com.daxv.common.ToolKit.JSONUtils;

import com.alibaba.fastjson.JSONObject;

import junit.framework.TestCase;

public class JsonTest extends TestCase {

	public void jsonTest() {
		Message message = new Message();
		message.setMessageBody("��ɽ������������");
		String string = JSONUtils.beanToJson(message);
		System.out.println(string);
		message = (Message) JSONUtils.jsonToBean(string, message);
	}

	public void TestWriteMq() { 
		new Bus(new Config("10.1.23.13", "daxu", "000000", "/"), new IBus() {
		 
			public void doQueueHandle(QueueHandler queueManager) {
				try {
					for (int i = 0; i < 200; i++) {
						PushInfo info = new PushInfo();
						info.setMessageBody("���");
						info.setJpushTime(new Date());
						if (queueManager.AddProducerMQ("daxu", info)) {
							System.out.println("���ͳɹ�");
						}
					} 
				} catch (Exception e) {
				}
			}
		}).Send();
	}

	public void TestReadMq() {
	
		new Bus(new Config("10.1.23.13", "daxu", "000000", "/"), new IBus() {
		
		 
			public void doQueueHandle(QueueHandler queueManager) { 
				do {
					for (int i = 0; i < 10; i++) {
						queueManager.GetQueues("daxu", new ReadQueueDao() {
						 
							public void ReadQueue(String pushInfo) {
								try {
									System.out.println("���յ�����Ϣ�ǣ�" + pushInfo);
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
}
