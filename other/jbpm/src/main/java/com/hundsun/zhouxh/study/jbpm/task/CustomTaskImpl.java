package com.hundsun.zhouxh.study.jbpm.task;

import org.jbpm.pvm.internal.task.TaskImpl;

public class CustomTaskImpl extends TaskImpl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int days;

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "CustomTaskImpl [days=" + days + ", isNew=" + isNew + ", name="
				+ name + ", description=" + description + ", assignee="
				+ assignee 
				+ ", formResourceName=" + formResourceName + ", createTime="
				+ createTime + ", duedate=" + duedate + ", progress="
				+ progress + ", priority="
				+ priority 
				+ ", executionId=" + executionId + ", activityName="
				+ activityName + ", swimlane=" + swimlane 
				+ ", dbid=" + dbid + ", dbversion=" + dbversion
				+ ", state=" + state + ", suspendHistoryState=";
	}

}
