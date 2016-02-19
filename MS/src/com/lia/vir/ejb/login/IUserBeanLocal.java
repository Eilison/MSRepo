package com.lia.vir.ejb.login;

import javax.ejb.Local;

@Local
public interface IUserBeanLocal {
	
	/*
	 * 创建用户
	 * lianghaihua
	 */
	public void createUser(UserPojo user); 

	/*
	 * 获取用户通过ID
	 * lianghaihua
	 */
	public UserPojo getUser(int id); 
}