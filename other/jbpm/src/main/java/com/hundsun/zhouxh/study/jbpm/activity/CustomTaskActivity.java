package com.hundsun.zhouxh.study.jbpm.activity;

import java.util.Map;

import org.jbpm.jpdl.internal.activity.TaskActivity;
import org.jbpm.pvm.internal.cal.Duration;
import org.jbpm.pvm.internal.el.Expression;
import org.jbpm.pvm.internal.env.EnvironmentImpl;
import org.jbpm.pvm.internal.history.HistoryEvent;
import org.jbpm.pvm.internal.history.events.TaskActivityStart;
import org.jbpm.pvm.internal.id.DbidGenerator;
import org.jbpm.pvm.internal.model.ExecutionImpl;
import org.jbpm.pvm.internal.session.DbSession;
import org.jbpm.pvm.internal.task.ParticipationImpl;
import org.jbpm.pvm.internal.task.SwimlaneDefinitionImpl;
import org.jbpm.pvm.internal.task.SwimlaneImpl;
import org.jbpm.pvm.internal.task.TaskImpl;

import com.hundsun.zhouxh.study.jbpm.task.TaskFactory;

public class CustomTaskActivity extends TaskActivity {

	private String taskType;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void execute(ExecutionImpl execution) {
		DbSession dbSession = EnvironmentImpl.getFromCurrent(DbSession.class);
		TaskFactory taskFactory = EnvironmentImpl.getFromCurrent(TaskFactory.class);
//		TaskImpl task = dbSession.createTask();
		
		TaskImpl task = taskFactory.createTask(taskType);
		long dbid = EnvironmentImpl.getFromCurrent(DbidGenerator.class).getNextId();
	    task.setDbid(dbid);
	    task.setNew(true);
	    
		task.setTaskDefinition(taskDefinition);
		task.setExecution(execution);
		task.setProcessInstance(execution.getProcessInstance());
		task.setSignalling(true);

		// initialize the name
		if (taskDefinition.getName() != null) {
			task.setName(taskDefinition.getName());
		} else {
			task.setName(execution.getActivityName());
		}

		Expression descriptionExpression = taskDefinition.getDescription();
		if (descriptionExpression != null) {
			String description = (String) descriptionExpression.evaluate(task);
			task.setDescription(description);
		}
		task.setPriority(taskDefinition.getPriority());
		task.setFormResourceName(taskDefinition.getFormResourceName());

		// calculate the due date of the task based on the due date duration
		String dueDateDescription = taskDefinition.getDueDateDescription();
		if (dueDateDescription != null) {
			task.setDuedate(Duration.calculateDueDate(dueDateDescription));
		}

		// save task so that TaskDbSession.findTaskByExecution works for assign
		// event listeners
		dbSession.save(task);

		SwimlaneDefinitionImpl swimlaneDefinition = taskDefinition
				.getSwimlaneDefinition();
		if (swimlaneDefinition != null) {
			SwimlaneImpl swimlane = execution
					.getInitializedSwimlane(swimlaneDefinition);
			task.setSwimlane(swimlane);

			// copy the swimlane assignments to the task
			task.setAssignee(swimlane.getAssignee());
			for (ParticipationImpl participant : swimlane.getParticipations()) {
				task.addParticipation(participant.getUserId(),
						participant.getGroupId(), participant.getType());
			}
		}

		execution.initializeAssignments(taskDefinition, task);

		HistoryEvent.fire(new TaskActivityStart(task), execution);

		execution.waitForSignal();
	}

	public String getTaskType() {
		return taskType;
	}

	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
}
