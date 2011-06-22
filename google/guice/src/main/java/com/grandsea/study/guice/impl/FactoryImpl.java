package com.grandsea.study.guice.impl;

import com.grandsea.study.guice.Factory;
import com.grandsea.study.guice.Resolver;
import com.grandsea.study.guice.annotation.AnnotationResolver;
import com.grandsea.study.guice.annotation.DatasetBean;

public class FactoryImpl implements Factory {

	public Resolver getResolver(Object object) {
		boolean isTransportClass = object.getClass().isAnnotationPresent(DatasetBean.class);
		if(isTransportClass){
			return new AnnotationResolver(object);
		}else{
			return new CommonResolver(object);
		}
	}
}
