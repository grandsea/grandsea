package com.grandsea.study.guice;

import java.util.Set;

public interface Resolver {
	
	public Set<String> getColumns();
	
	public Object getValue(String column, Object target);
}
