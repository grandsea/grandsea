/*
 * 系统名称: JRES-工作流
 * 模块名称: 
 * 类 名 称: TestException.java
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
package com.zhouxh.spring.exception;

/**
 * 功能说明: <BR> 
 * 系统版本:  <BR>
 * 开发人员: zhouxh<BR>
 * 开发时间: 2010-11-9<BR>
 *<BR>
 */
public class TestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public TestException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public TestException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 */
	public TestException(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public TestException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

}
