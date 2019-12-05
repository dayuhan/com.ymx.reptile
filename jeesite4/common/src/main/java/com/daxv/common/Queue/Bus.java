package com.daxv.common.Queue;

import com.daxv.common.Bus.IBus;
 
  
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
			//queueManager.SendQueue() ;
			flag=true;
		} catch (Exception e) {
			// TODO: handle exception
			flag=false;
		}
	return flag;
	}
 
  
}