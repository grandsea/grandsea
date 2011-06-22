/*
 * 系统名称: JRES-工作流
 * 模块名称: 
 * 类 名 称: MyAntTask.java
 * 软件版权: 杭州恒生电子股份有限公司
 * 相关文档:
 * 修改记录:
 * 修改日期      修改人员                     修改说明<BR>
 * ======== ======  ============================================
 * 2010-11-9	zhouxh		新建  
 * ======== ======  ============================================
 * 评审记录：
 * 
 * 评审人员：
 * 评审日期：
 * 发现问题：
 */
package com.zhouxh.ant;

import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

/**
 * 功能说明: <BR> 
 * 系统版本:  <BR>
 * 开发人员: zhouxh<BR>
 * 开发时间: 2010-11-9<BR>
 *<BR>
 */
public class MyAntTask extends Task {

	private boolean active;
	
	private String name;
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/**
	 * 
	 */
	public MyAntTask() {
		// TODO Auto-generated constructor stub
	}

	public void execute() throws BuildException {
		System.out.println("This is My own task! " + name + " active:" + active);
	}

}
