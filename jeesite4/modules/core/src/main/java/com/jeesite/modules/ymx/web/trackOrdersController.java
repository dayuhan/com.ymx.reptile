package com.jeesite.modules.ymx.web;

import java.util.Date;

import org.apache.http.client.methods.HttpGet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daxv.common.Bus.IBus;
import com.daxv.common.Bus.PushInfo;
import com.daxv.common.Queue.Bus;
import com.daxv.common.Queue.Config;
import com.daxv.common.Queue.QueueHandler;
import com.jeesite.common.web.BaseController;

@Controller
@RequestMapping("${adminPath}/ymx/trackOrders")
public class trackOrdersController extends BaseController {

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String trackOrdersIndex() {  	 
		return "modules/ymx/index";
	}
	/*
	 * 查询
	 */
	@ResponseBody
	@RequestMapping(value="/spiderApi",method=RequestMethod.POST) 
	public String spiderApi(String name) {
		try {   
			 //new Bus(new Config("${queueConfig.hostName}", "${queueConfig.userName}", "${queueConfig.passWord}", "${queueConfig.virtualHost}"), new IBus() { 
			new Bus(new Config("192.168.43.93", "daxu", "13528764027", "dxhost"), new IBus() {	 
				public void doQueueHandle(QueueHandler queueManager) {
					try {
						for (int i = 0; i < 1; i++) {
							PushInfo info = new PushInfo();
							info.setMessageBody(i);
							info.setJpushTime(new Date());
							if (queueManager.AddProducerMQ("daxu", info)) {
								System.out.println("发送成功"); 
							}else {
								System.out.println("发送失败了");
							}
							
						}
					} catch (Exception e) {
					}
				}
			}).Send();
			System.out.println("~~~~~~~~~~~推送完毕~~~~~~~~~~~~~~·");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return name; 
	}
	
	
	
}
