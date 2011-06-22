package com.hundsun.zhouxh.study.jbpm;

import java.util.List;

import org.jbpm.api.Configuration;
import org.jbpm.api.ExecutionService;
import org.jbpm.api.ProcessEngine;
import org.jbpm.api.RepositoryService;
import org.jbpm.api.TaskService;
import org.jbpm.api.task.Task;

public class Main {

	public static void main(String[] args) {
		
		// Build jBPM services
		ProcessEngine processEngine = new Configuration().buildProcessEngine();
		RepositoryService repositoryService = processEngine.getRepositoryService();
		ExecutionService executionService = processEngine.getExecutionService();
		TaskService taskService = processEngine.getTaskService();
		
		// Deploy helloWorld process definition and start a process instance
		repositoryService.createDeployment().addResourceFromClasspath("jpdl/hello_world.jpdl.xml").deploy();
		executionService.startProcessInstanceByKey("helloWorld");
		List<Task> taskList = taskService.findPersonalTasks("admin");
		while(taskList.size() > 0){
			for(Task task : taskList){
				System.out.println(task.toString());
				taskService.completeTask(task.getId());
			}
			taskList = taskService.findPersonalTasks("admin");
		}
	}
	
}
