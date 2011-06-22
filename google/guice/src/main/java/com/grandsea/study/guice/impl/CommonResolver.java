package com.grandsea.study.guice.impl;

import java.lang.reflect.Method;

public class CommonResolver extends AbstractResolver{

	public CommonResolver(Object object){
		Method[] methods = object.getClass().getMethods();
		for(Method method : methods){
			String methodName = method.getName();
			if("getClass".equals(methodName)){
				continue;
			}
			if(methodName.startsWith("get") || methodName.startsWith("is")){
				int index = 2;
				if(methodName.startsWith("get")){
					index = 3;
				}
				String column = methodName.substring(index, index + 1).toLowerCase() + methodName.substring(index + 1);
				this.methodMap.put(column, method);
			}
		}
	}
}
