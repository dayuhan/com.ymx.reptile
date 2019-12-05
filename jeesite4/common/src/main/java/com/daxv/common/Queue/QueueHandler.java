package com.daxv.common.Queue;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.daxv.common.Bus.PushTypeBase;
 

public class QueueHandler extends QueueFactory {

	public Config config;
	public QueueHandler() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public QueueHandler(Config configInfo) {
		super();
		config = configInfo;
	} 
	/**
	 * 添加到队列
	 */
	@Override
	public boolean AddProducerMQ(String queueName, PushTypeBase pushInfo) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = this.getQueueByConfig(config).AddProducerMQ(queueName,
					pushInfo);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
	/**
	 * 获取队列       **异步**
	 */
	@Override
	public String GetQueues(String queueName,ReadQueueDao rQueueDao) {
		String jsonStr = null;
		try {
			jsonStr = this.getQueueByConfig(config).GetQueues(queueName,rQueueDao);

		} catch (Exception e) {
			// TODO: handle exception
		}
		return jsonStr;
	}

 
}
