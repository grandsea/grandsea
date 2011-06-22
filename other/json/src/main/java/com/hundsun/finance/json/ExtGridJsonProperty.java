package com.hundsun.finance.json;

public class ExtGridJsonProperty {
	
	public String getTotalProperty() {
		return totalProperty;
	}
	public void setTotalProperty(String totalProperty) {
		this.totalProperty = totalProperty;
	}
	public String getRootProperty() {
		return rootProperty;
	}
	public void setRootProperty(String rootProperty) {
		this.rootProperty = rootProperty;
	}
	public String getSuccessProperty() {
		return successProperty;
	}
	public void setSuccessProperty(String successProperty) {
		this.successProperty = successProperty;
	}

	private String totalProperty = DEFAULT_TOTAL_PROPERTY;
	private String rootProperty = DEFAULT_ROOT;
	private String successProperty = DEFAULT_SUCCESS_PROPERTY;
	
	private static final String DEFAULT_ROOT = "data";
	private static final String DEFAULT_TOTAL_PROPERTY = "totalRow";
	private static final String DEFAULT_SUCCESS_PROPERTY = "success";
	
}
