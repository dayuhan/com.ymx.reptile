package com.jeesite.modules.ymx.web;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.daxv.common.Bus.SocketInfo;
import com.daxv.common.ToolKit.JSONUtils;
import com.daxv.common.WebSocket.WebSocket;
 

@Controller
@RequestMapping(value="${adminPath}/ymx/spiderResultAPi")
public class spiderResultAPiController {

	@ResponseBody
	@RequestMapping(value="/spiderResultAPi",method=RequestMethod.POST)
	public String spiderResultAPi(String name ,String sex) { 
		System.out.println("开始获取爬虫返回结果");
		System.out.println(String.format("name:%s  sex:%s", name,sex));
		try { 
			System.out.println("开始获取爬虫返回结果");
			WebSocket ws = new WebSocket();	
			SocketInfo sInfo=new SocketInfo();
			sInfo.setMessAge("dad");
			sInfo.setTo("All");
			ws.onMessage(JSONUtils.beanToJson(sInfo));
			System.out.println("返回查询结果");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}  
		return "服务端收到请求。。。"; 
	}
}
