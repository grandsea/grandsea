package com.grandsea.study.guice.annotation;

@DatasetBean
public class AnnotationBean {

	@DatasetField
	private String name;
	
	@DatasetField
	private String value;
	
	@DatasetField
	private int count;
	
	public AnnotationBean(String name, String value, int count) {
		super();
		this.name = name;
		this.value = value;
		this.count = count;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
