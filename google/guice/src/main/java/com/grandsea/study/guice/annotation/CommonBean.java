package com.grandsea.study.guice.annotation;

public class CommonBean {

	private String name;
	private String value;
	
	private int count;

	public CommonBean(String name, String value, int count) {
		super();
		this.name = name;
		this.value = value;
		this.count = count;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}

	public int getCount() {
		return count;
	}
}
