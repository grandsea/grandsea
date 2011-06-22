package com.zhouxh.spring.hibernate.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zhouxh.spring.exception.TestException;
import com.zhouxh.spring.hibernate.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/applicationContext.xml"})
@Transactional(rollbackFor={RuntimeException.class})
public class UserServiceTest {

	@Autowired
	private UserService userService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	@Rollback(false)
	public void insertAATest() throws TestException{
		userService.insertAA();
	}
	@Test
	@Rollback(false)
	public void insertBBTest() throws TestException{
		userService.insertBB();
	}
	@Test
	public void sayHelloTest() throws TestException{
		userService.sayHello();
	}
}
