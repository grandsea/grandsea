package com.hundsun.zhouxh.study.jbpm.task;

import org.jbpm.pvm.internal.task.TaskImpl;

public class CustomTaskImpl2 extends TaskImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "CustomTaskImpl2 [value=" + value + ", isNew=" + isNew
				+ ", name=" + name + ", description=" + description
				+ ", assignee=" + assignee + ", formResourceName="
				+ formResourceName + ", createTime=" + createTime
				+ ", duedate=" + duedate + ", progress=" + progress
				+ ", priority=" + priority + ", activityName=" + activityName
				+ ", swimlane=" + swimlane + ", dbid=" + dbid + ", dbversion="
				+ dbversion + ", state=" + state + "]";
	}

}
