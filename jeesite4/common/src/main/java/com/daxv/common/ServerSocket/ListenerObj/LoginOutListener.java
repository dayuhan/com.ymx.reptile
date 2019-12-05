package com.daxv.common.ServerSocket.ListenerObj;

import com.daxv.common.Bus.PushTypeBase;
import com.daxv.common.ServerSocket.MessageSender;
import com.daxv.common.ServerSocket.OnRecevieMsgListener;
import com.daxv.common.ToolKit.JSONUtils;

//import org.eclipse.jdt.internal.compiler.ast.MessageSend;
//import org.eclipse.jdt.internal.compiler.ast.MessageSend;
 

public class LoginOutListener  extends MessageSender implements OnRecevieMsgListener {

	public void onReceive(PushTypeBase msg) {
		// TODO Auto-generated method stub
		System.out.println(String.format("我是LoginOutListener，我收到消息了,消息为：%s", JSONUtils.beanToJson(msg)));
	}
 

}
