package com.grandsea.study.guice;

public interface Factory {

	public Resolver getResolver(Object clazz);
}
