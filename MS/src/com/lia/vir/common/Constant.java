package com.lia.vir.common;

public class Constant {

	/*
	 * 日志类型标签
	 */
	public enum LogEnum
	{
		INFOR("INFOR"), 
		ERROR("ERROR"), 
		OTHER("OTHER");
		
		private final String value;
		
		LogEnum(String avalue)
		{
			this.value = avalue;
		}
		
		public String getValue()
		{
			return value;
		}
	}
	
	/*
	 * 返回数据信息
	 */
	public static String SUCCESS = "success";
	public static String INPUT_VAlUE_ERROR = "input_error";
	public static String STACK_ERROR = "stact_error";
	
	public static String S_POJECT_NAME = "MS";
	public static String S_LOCAL_SESSION = "local";
	public static String S_REMOTE_SESSION = "remote";
	
	//空字符
	public static String S_NULL = "";
	
	
}
