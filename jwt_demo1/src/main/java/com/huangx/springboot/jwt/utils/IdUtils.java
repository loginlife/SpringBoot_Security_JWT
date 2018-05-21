package com.huangx.springboot.jwt.utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Administrator on 2018/5/18.
 */
public class IdUtils {
	private static final AtomicLong ID_GEN = new AtomicLong();

	/**
	 * 获取新的 Person ID
	 * @return
	 */
	public static long getId() {
		return ID_GEN.incrementAndGet();
	}

}
