package com.daxv.common.Queue;

import com.daxv.common.Bus.IBus;
 
 /**
  * 队列服务 
  * @author Administrator
  *
  */
public class Bus {
	public IBus ibus;
	public QueueHandler queueHandler;
	 
	public Bus(Config config,IBus person) {  
		queueHandler=new QueueHandler(config);
		ibus=person;
	}   
	public boolean Send() {
		boolean flag=false;
		try {
			ibus.doQueueHandle(queueHandler);
			//释放TCP通道
			queueHandler.getQueue().getRaMqUtil().dispose(); 
			flag=true;
		} catch (Exception e) {
			// TODO: handle exception
			flag=false;
		}
	return flag;
	}
 
  
}
