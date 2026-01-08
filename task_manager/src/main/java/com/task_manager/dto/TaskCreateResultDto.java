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
	private TaskCreateResultDto() {
		this.isCreated = true;
		this.taskErrorType = null;
	}
	
	/** 
	 * タスク登録失敗時のコンストラクタ
	 * */
	private TaskCreateResultDto(TaskErrorType taskErrorType) {
		this.isCreated = false;
		this.taskErrorType = taskErrorType;
	}
	
	/** 
	 * タスク登録成功時の結果を返すファクトリメソッド
	 * 
	 * @return タスク登録成功を示す{@link TaskCreateResultDto} インスタンス
	 * */
	public static TaskCreateResultDto succeed() {
		return new TaskCreateResultDto();
	}
	
	/** 
	 * タスク登録失敗時の結果を返すファクトリメソッド
	 * 
	 * @param taskErrorType タスク登録失敗の原因を表すエラー種別
	 * @return タスク登録失敗を示す{@link TaskCreateResultDto}　インスタンス
	 * */
	public static TaskCreateResultDto failed(TaskErrorType taskErrorType) {
		return new TaskCreateResultDto(taskErrorType);
	}
}
