package com.hundsun.finance.json;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class ExtHelperTest {

	@Test
	public void testGetGridJsonFromList() throws IOException {
		ExtHelper helper = ExtHelper.createHelper();
		helper.getConfig().setExcludes(new String[]{"model"});
		
		List list = new ArrayList();
		for(int i = 0; i< 10; i++){
			SimpleDataModel model = new SimpleDataModel();
			model.setId("" + i);
			model.setName("name" + i);
			model.setPhone("phone" + i);
			list.add(model);
		}
		ExtGridJson gridJson = new ExtGridJson(110, list);
		String json = helper.getGridJsonFromList(gridJson);
//		System.out.println(json);
		
		String expectJson = IOUtils.toString(SimpleDataModel.class.getResourceAsStream("SimpleDataModel_GridJson.txt"));
		assertEquals(expectJson, json);
	}

}
