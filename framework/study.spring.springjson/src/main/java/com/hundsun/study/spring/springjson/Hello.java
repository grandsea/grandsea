package com.hundsun.study.spring.springjson;

public class Hello {

	private String name;
	private boolean sex;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
	public String toStirng(){
		return this.name + "-" + (this.sex?"男":"女");
	}
}
