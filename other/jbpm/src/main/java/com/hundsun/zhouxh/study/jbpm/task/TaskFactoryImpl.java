package com.hundsun.zhouxh.study.jbpm.task;

import org.apache.commons.lang.StringUtils;
import org.jbpm.pvm.internal.task.TaskImpl;

public class TaskFactoryImpl implements TaskFactory {

	@Override
	public TaskImpl createTask(String taskType) {
		if(StringUtils.isNotEmpty(taskType)){
			try {
				Class clazz = Class.forName(taskType);
				if(TaskImpl.class.isAssignableFrom(clazz)){
					try {
						return (TaskImpl)clazz.newInstance();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new TaskImpl();
	}

}
