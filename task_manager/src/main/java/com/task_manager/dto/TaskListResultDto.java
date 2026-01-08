package com.task_manager.dto;

import java.util.List;

import com.task_manager.form.TaskRowForm;
import com.task_manager.util.TaskErrorType;

import lombok.Getter;

@Getter
public class TaskListResultDto {
	
	private final List<TaskRowForm> tasks;
	
	private final boolean hasTasks;
	
	private final TaskErrorType taskErrorType;
	
	
	/** 
	 * タスクリスト生成成功時のコンストラクタ
	 * 
	 * @param tasks
	 * */
	private TaskListResultDto(List<TaskRowForm> tasks) {
		this.tasks = tasks;
		this.hasTasks = true;
		this.taskErrorType = null;
	}
	
	/** 
	 * タスクリスト生成失敗時のコンストラクタ
	 * 
	 * @param tasks
	 * */
	private TaskListResultDto(TaskErrorType taskErrorType) {
		this.hasTasks = false;
		this.taskErrorType = taskErrorType;
		//使用しないフィールドにはnullを入力
		this.tasks = null;
	}
	
	/** 
	 * タスクリスト生成成功時の結果を返すファクトリメソッド
	 * 
	 * @param tasks {@link TaskRowForm}のリスト
	 * @return タスクリスト生成成功を示す{@link TaskListResultDto}インスタンス
	 * */
	public static TaskListResultDto succeedTaskListForm(List<TaskRowForm> tasks) {
		return new TaskListResultDto(tasks);
	}
	
	/** 
	 * タスクリスト生成失敗時の結果を返すファクトリメソッド
	 * 
	 * @param taskErrorType
	 * @return タスクリスト生成失敗を示す{@link TaskListResultDto}インスタンス
	 * */
	public static TaskListResultDto failedTaskListForm(TaskErrorType taskErrorType) {
		return new TaskListResultDto(taskErrorType);
	}

}
