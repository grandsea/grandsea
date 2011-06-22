package com.zhouxh.spring.hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhouxh.spring.exception.TestException;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	private UserService userService;
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/* (non-Javadoc)
	 * @see com.zhouxh.spring.hibernate.service.RoleService#insert()
	 */
	public void insertAA() {
		try{
			userService.insertA();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.zhouxh.spring.hibernate.service.RoleService#update()
	 */
	public void insertBB() {
		try {
			userService.insertB();
		} catch (TestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
