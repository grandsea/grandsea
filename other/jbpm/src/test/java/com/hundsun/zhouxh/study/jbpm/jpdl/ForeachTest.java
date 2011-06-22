package com.hundsun.zhouxh.study.jbpm.jpdl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


public class ForeachTest {

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
	public void testForeach() throws Exception{
		repositoryService.createDeployment().addResourceFromClasspath("jpdl/foreach.jpdl.xml").deploy();

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("humans", new String[] { "huws", "zhouxh", "xujin" });
		variables.put("human_count", 3);
		ProcessInstance processInstance = executionService.startProcessInstanceByKey("ForEach", variables);
		
		List<Task> taskList = taskService.createTaskQuery().processInstanceId(processInstance.getId()).activityName("Collect reports").list();
		System.out.println(taskList.toString());
		
		taskService.completeTask(taskList.get(0).getId());
		taskList = taskService.createTaskQuery().processInstanceId(processInstance.getId()).activityName("Collect reports").list();
		System.out.println(taskList.toString());
		
		taskService.completeTask(taskList.get(0).getId());
		taskList = taskService.createTaskQuery().processInstanceId(processInstance.getId()).activityName("Collect reports").list();
		System.out.println(taskList.toString());
		
		taskService.completeTask(taskList.get(0).getId());
		taskList = taskService.createTaskQuery().processInstanceId(processInstance.getId()).activityName("Collect reports").list();
		System.out.println(taskList.toString());
	}
}
