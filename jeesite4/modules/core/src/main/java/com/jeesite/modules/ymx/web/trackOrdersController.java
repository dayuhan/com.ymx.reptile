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
		System.out.println("~~~~~~~~~~~开始推送到队列~~~~~~~~~~~~~~·");
		new Bus(new Config("192.168.43.93", "daxu", "13528764027", "dxhost"), new IBus() {	
			 
			public void doQueueHandle(QueueHandler queueManager) {
				try {
					for (int i = 0; i < 10000; i++) {
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
		
		return "modules/ymx/index";
	}
	@ResponseBody
	@RequestMapping(value="/spiderApi",method=RequestMethod.POST)
	
	public String spiderApi(String name) {
		try {
			System.out.println("#########你好我进来了我是post请求########");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return name;
		
	}
}
