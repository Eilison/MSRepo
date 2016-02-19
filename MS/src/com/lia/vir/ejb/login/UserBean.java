package com.lia.vir.ejb.login;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
 * lianghaihua
 */
@Stateless
public class UserBean implements IUserBeanLocal{
	
	@PersistenceContext(unitName = "entity")
	private EntityManager manager;
	
	/*
	 * 创建用户
	 * @see com.lia.vir.ejb.login.IUserBeanLocal#createUser(com.lia.vir.ejb.login.User)
	 */
	public void createUser(UserPojo user) {
		manager.persist(user);
	}
	
	/*
	 * 获取用户通过ID
	 * @see com.lia.vir.ejb.login.IUserBeanLocal#getUser(int)
	 */
	public UserPojo getUser(int id) {
		return manager.find(UserPojo.class, id);
	}
}
