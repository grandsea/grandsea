package com.grandsea.study.guice.impl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.grandsea.study.guice.Resolver;

public abstract class AbstractResolver implements Resolver {

	
	protected Map<String, Method> methodMap = new HashMap<String, Method>();

	public Set<String> getColumns() {
		return methodMap.keySet();
	}

	public Object getValue(String column, Object target) {
		try {
			return methodMap.get(column).invoke(target);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
