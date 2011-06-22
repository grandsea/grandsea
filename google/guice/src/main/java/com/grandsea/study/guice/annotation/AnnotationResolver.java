package com.grandsea.study.guice.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.apache.commons.lang.StringUtils;

import com.grandsea.study.guice.impl.AbstractResolver;

public class AnnotationResolver extends AbstractResolver {
	
	public AnnotationResolver(Object object){
		boolean isTransportClass = object.getClass().isAnnotationPresent(DatasetBean.class);
		if(isTransportClass){
			Field[] fields = object.getClass().getDeclaredFields();
			for(Field field : fields){
				boolean isTransportField = field.isAnnotationPresent(DatasetField.class);
				if(isTransportField){
					DatasetField transportField = field.getAnnotation(DatasetField.class);
					String name = transportField.name();
					if(StringUtils.isBlank(name)){
						name = field.getName();
					}
					String methodName = "get" + name.substring(0,1).toUpperCase() + name.substring(1);
					Method method;
					try {
						method = object.getClass().getMethod(methodName);
						methodMap.put(name, method);
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
	
}
