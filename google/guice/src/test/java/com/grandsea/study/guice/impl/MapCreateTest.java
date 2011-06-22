package com.grandsea.study.guice.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.grandsea.study.guice.MapCreateModule;
import com.grandsea.study.guice.MapCreator;
import com.grandsea.study.guice.annotation.AnnotationBean;
import com.grandsea.study.guice.annotation.CommonBean;

public class MapCreateTest {

	private List<AnnotationBean> list;
	
	private List<CommonBean> commonBeans;
	
	private MapCreator datasetCreator;
	
	private static Injector injector;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		injector = Guice.createInjector(new MapCreateModule());
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		list = new ArrayList<AnnotationBean>();
		list.add(new AnnotationBean("周雄海", "grandsea", 25));
		list.add(new AnnotationBean("周雄海2", "grandsea2", 24));
		
		commonBeans = new ArrayList<CommonBean>();
		commonBeans.add(new CommonBean("周雄海55", "grandsea54", 2554));
		commonBeans.add(new CommonBean("周雄海254", "grandsea24", 2454));
		
		datasetCreator = injector.getInstance(MapCreator.class);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testAnnotation(){
		List<Map> result = datasetCreator.create(list, 9);
		System.out.print(result);
	}
	
	@Test
	public void testCommon(){
		List<Map> result = datasetCreator.create(commonBeans, 9);
		System.out.print(result);
	}
}
