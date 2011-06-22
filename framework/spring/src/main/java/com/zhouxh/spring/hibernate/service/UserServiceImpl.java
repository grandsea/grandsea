package com.zhouxh.spring.hibernate.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhouxh.spring.exception.TestException;

@Service("userService")
public class UserServiceImpl implements UserService {

	/* (non-Javadoc)
	 * @see com.zhouxh.spring.hibernate.service.UserService#insertA()
	 */
	@Transactional(noRollbackFor=NullPointerException.class)
	public void insertA() throws NullPointerException{
		System.out.println("insert A");
		throw new NullPointerException();
	}
	
	/* (non-Javadoc)
	 * @see com.zhouxh.spring.hibernate.service.UserService#insertC()
	 */
	public void insertB() throws TestException{
		System.out.println("insert B");
		throw new TestException();
	}
	
	/* (non-Javadoc)
	 * @see com.zhouxh.spring.hibernate.service.UserService#insertB()
	 */
	public void insertAA() {
		try{
			insertA();
		}catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see com.zhouxh.spring.hibernate.service.UserService#insertD()
	 */
	public void insertBB() {
		try {
			insertB();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sayHello(){
		System.out.println("Hello World!");
	}
}
