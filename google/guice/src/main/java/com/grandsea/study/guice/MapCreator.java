package com.grandsea.study.guice;

import java.util.List;
import java.util.Map;

public interface MapCreator {

	public List<Map> create(List list);
	
	public List<Map> create(List list, int count);
	
	public Map create(Object object);
}
