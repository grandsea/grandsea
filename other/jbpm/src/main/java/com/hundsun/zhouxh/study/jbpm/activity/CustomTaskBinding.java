package com.hundsun.zhouxh.study.jbpm.activity;

import org.jbpm.jpdl.internal.activity.JpdlBinding;
import org.jbpm.jpdl.internal.xml.JpdlParser;
import org.jbpm.pvm.internal.model.ScopeElementImpl;
import org.jbpm.pvm.internal.task.TaskDefinitionImpl;
import org.jbpm.pvm.internal.util.XmlUtil;
import org.jbpm.pvm.internal.xml.Parse;
import org.w3c.dom.Element;

import com.hundsun.zhouxh.study.jbpm.task.CustomTaskImpl;

public class CustomTaskBinding extends JpdlBinding {

	private static final String TAG = "customTask";

	public CustomTaskBinding() {
		super(TAG);
	}

	public Object parseJpdl(Element element, Parse parse, JpdlParser parser) {
		CustomTaskActivity taskActivity = new CustomTaskActivity();

		ScopeElementImpl scopeElement = parse
				.contextStackFind(ScopeElementImpl.class);
		TaskDefinitionImpl taskDefinition = parser.parseTaskDefinition(element,
				parse, scopeElement);
		taskActivity.setTaskDefinition(taskDefinition);
		
		String taskType = XmlUtil.attribute(element, "taskType");
		taskActivity.setTaskType(taskType);

		return taskActivity;
	}
}
