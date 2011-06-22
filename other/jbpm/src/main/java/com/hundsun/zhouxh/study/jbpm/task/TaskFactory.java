package com.hundsun.zhouxh.study.jbpm.task;

import org.jbpm.pvm.internal.task.TaskImpl;

public interface TaskFactory {

	public TaskImpl createTask(String taskType);
}
