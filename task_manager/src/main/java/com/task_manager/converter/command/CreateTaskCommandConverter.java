package com.task_manager.converter.command;

import org.springframework.stereotype.Component;
import com.task_manager.entity.TaskEntity;
import com.task_manager.form.CreateTaskForm;

@Component
public class CreateTaskCommandConverter {

	/** 
	 * {@link CreateTaskForm}型のオブジェクトを{@link TaskEntity}に変換する
	 * 
	 * @param createTaskForm {@link CreateTaskForm}型のオブジェクト
	 * @return taskEntity {@link TaskEntity}型の成形済のオブジェクト
	 * 
	 * */
	public TaskEntity convert(CreateTaskForm createTaskForm) {
		TaskEntity taskEntity = new TaskEntity();
		taskEntity.setTaskName(trimToNull(createTaskForm.getTaskName()));
		taskEntity.setTaskDscript(trimToNull(createTaskForm.getTaskDscript()));
		taskEntity.setDueDate(createTaskForm.getDueDate());
		taskEntity.setPriority(createTaskForm.getPriority());
		taskEntity.setStatus(createTaskForm.getStatus());
		taskEntity.setMngUser(createTaskForm.getMngUser());
		return taskEntity;
	}
	
	/** 
	 * 指定された文字列の前後の空白を除去し、
	 * 結果が空文字となる場合
	 * 
	 * @param value トリム対象の文字列({@code null} 可)
	 * @return trimmed トリム後の文字列
	 * 入力が {@code null} の場合、またはトリム後に空文字列となる場合は {@code null}
	 * 
	 * */
	private String trimToNull(String value) {
		if (value == null) {
			return null;
		} else {
			String trimmed = value.trim();
			return trimmed.isEmpty() ? null :trimmed;
		}
	}

}
