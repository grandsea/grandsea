package com.grandsea.study.guice.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.inject.Inject;
import com.grandsea.study.guice.Factory;
import com.grandsea.study.guice.MapCreator;
import com.grandsea.study.guice.Resolver;

public class MapCreatorImpl implements MapCreator {

	private Factory factory;
	
	@Inject
	public MapCreatorImpl(Factory factory) {
		this.factory = factory;
	}

	public List<Map> create(List list) {
		return create(list, list.size());
	}

	public List<Map> create(List list, int count) {
		List<Map> result = new ArrayList<Map>();
		
		
		if(list.isEmpty()){
			return result;
		}
		
		Object object = list.get(0);
		
		Resolver resolver = factory.getResolver(object);
		
		for(Object row : list){
			Map map = new HashMap();
			Set<String> columns = resolver.getColumns();
			for(String column : columns){
				map.put(column, resolver.getValue(column, row));
			}
			result.add(map);
		}
		
		return result;
	}

	public Map create(Object object) {
		
		Map map = new HashMap();
		Resolver resolver = factory.getResolver(object);
		
		Set<String> columns = resolver.getColumns();
		for(String column : columns){
			map.put(column, resolver.getValue(column, object));
		}
		
		return map;
	}

}
