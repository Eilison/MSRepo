package com.lia.vir.common;

import com.lia.vir.common.Constant.LogEnum;

public class LogUtil {

	/*
	 * 输出日志
	 */
	public static boolean log(LogEnum tag, String infor)
	{
		boolean _b = true;
		System.out.print(tag.getValue()
				+ " : "
				+ infor);
		return _b;
	}
}
