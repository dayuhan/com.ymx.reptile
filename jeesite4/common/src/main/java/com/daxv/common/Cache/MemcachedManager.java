package com.daxv.common.Cache;

import java.util.Calendar;

public class MemcachedManager {

	// / <summary>
	// / 缓存代理
	// / </summary>
	public final static MemcachedUtil memCache = new MemcachedUtil();

	// / <summary>
	// / 初始化缓存
	// / </summary>
	public static void InitMemCache(String poolName) {
		if (memCache != null) {
			System.out.println("初始化缓存");
			memCache.InitMemCacheMagent(poolName);
		}else
		{
			System.err.println("已经初始化");
		} 
	}

	public static MemcachedUtil getMemCache() {
		return memCache;
	}

}
