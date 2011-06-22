package com.zhouxh.spring.hibernate.service;

import com.zhouxh.spring.exception.TestException;

public interface UserService {

	public abstract void insertA() throws NullPointerException;

	public abstract void insertB() throws TestException;

	public abstract void insertAA() ;

	public abstract void insertBB();

	public abstract void sayHello();
}