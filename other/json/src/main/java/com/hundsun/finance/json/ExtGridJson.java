package com.hundsun.finance.json;

import java.util.List;

public class ExtGridJson{

	
	public ExtGridJson() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExtGridJson(int totalCount, List valueList) {
		super();
		this.totalCount = totalCount;
		this.valueList = valueList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List getValueList() {
		return valueList;
	}
	public void setValueList(List valueList) {
		this.valueList = valueList;
	}
	
	public ExtGridJsonProperty getProperty() {
		return property;
	}

	private int totalCount;
	private boolean success = true;
	private List valueList;
	private ExtGridJsonProperty property = new ExtGridJsonProperty();
}
