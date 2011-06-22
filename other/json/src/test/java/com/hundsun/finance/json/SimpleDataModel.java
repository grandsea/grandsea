package com.hundsun.finance.json;

public class SimpleDataModel {

	private String id;
	private String name;
	private String phone;
	private SimpleDataModel model = this;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public SimpleDataModel getModel() {
		return model;
	}
	public void setModel(SimpleDataModel model) {
		this.model = model;
	}
}
