package com.daxv.common.Bus;

import java.util.Date;

/**
 * 所有消息实体继承此类
 *
 */
public abstract class PushTypeBase {
	private int pushType;
	private Date jpushTime;

 

	public int getPushType() {
		return pushType;
	}

	public void setPushType(int pushType) {
		this.pushType = pushType;
	}

	public Date getJpushTime() {
		return new Date();
	}

	public void setJpushTime(Date jpushTime) {
		jpushTime = jpushTime;
	}

}
