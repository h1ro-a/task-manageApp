package com.task_manager.dto;

import com.task_manager.util.TaskErrorType;

import lombok.Getter;


@Getter
public class TaskCreateResultDto {
	
	private final boolean isCreated;
	
	private final TaskErrorType taskErrorType;
	
	/** 
	 * タスク登録成功時のコンストラクタ
	 * */
	public TaskCreateResultDto() {
		this.isCreated = true;
		this.taskErrorType = null;
	}
}
