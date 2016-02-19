package com.lia.vir.action.User;


import java.util.Date;

import javax.naming.NamingException;

import com.lia.vir.common.Constant;
import com.lia.vir.common.Constant.LogEnum;
import com.lia.vir.common.LogUtil;
import com.lia.vir.common.Tools;
import com.lia.vir.ejb.login.IUserBeanLocal;
import com.lia.vir.ejb.login.UserPojo;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * 登陆
 * @author lianghaihua
 *
 */
public class UserRegistAction extends ActionSupport{
	/** * */
	private static final long serialVersionUID = 1L;
	
	private String userName;
	private String userPwd;
	private String msg;

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String password) {
		this.userPwd = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getMsg() {
		return msg;
	}

	public String execute()
	{
		LogUtil.log(LogEnum.INFOR, "start login");
		//判断输入是否为空值
		if ("".equals(userName) || "".equals(userPwd))
		{
			LogUtil.log(LogEnum.ERROR, "input value error : " + userName + ", " + userPwd);
			msg = Constant.INPUT_VAlUE_ERROR;
			return ERROR;
		}
		try 
		{
			IUserBeanLocal ubr = (IUserBeanLocal)Tools.getRemoteSessionBean("UserBean", 
					  Constant.S_NULL);
			UserPojo user = new UserPojo();
			user.setName(userName);
			user.setPwd(userPwd);
			Date date = new Date(System.currentTimeMillis());
			user.setRegistTime(date);
			ubr.createUser(user);
			msg = Constant.SUCCESS;
			LogUtil.log(LogEnum.INFOR, "new user regist end");
		} catch (NamingException e) {
			
			msg = Constant.STACK_ERROR;
			e.printStackTrace();
		}
		LogUtil.log(LogEnum.INFOR, "new user regist success");
		return SUCCESS;
	}
    
}