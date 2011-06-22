package com.hundsun.zhouxh.study.jbpm.jpdl;


import org.jbpm.api.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.ProcessInstance;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ForkTest {

	private static ProcessEngine processEngine = new Configuration().buildProcessEngine();
	private static RepositoryService repositoryService = processEngine.getRepositoryService();
	private static ExecutionService executionService = processEngine.getExecutionService();
	private static TaskService taskService = processEngine.getTaskService();
	
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
	public void testFork() throws Exception{
		repositoryService.createDeployment().addResourceFromClasspath("jpdl/fork.jpdl.xml").deploy();
		ProcessInstance processInstance = executionService.startProcessInstanceByKey("AsyncFork");
		
		Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).activityName("自定义任务1").uniqueResult();
		System.out.println(task.toString());
	}
}
