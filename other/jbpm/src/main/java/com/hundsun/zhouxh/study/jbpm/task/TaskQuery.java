package com.hundsun.zhouxh.study.jbpm.task;

import java.util.List;

import org.jbpm.api.task.Task;

public interface TaskQuery {

	public List<Task> list();
	
	public Task uniqueResult();
	
	public TaskQuery processInstanceId(String processInstanceId);
	
	public TaskQuery nodeName(String nodeName);
	
	
}
