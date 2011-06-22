package mvc;

public class User {

	String name = "UserName";
	
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString(){
		return "我的名字叫：" + this.name;
	}
}
