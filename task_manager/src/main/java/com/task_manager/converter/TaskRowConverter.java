package com.task_manager.converter;

import java.text.SimpleDateFormat;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.task_manager.entity.TaskEntity;
import com.task_manager.entity.UserEntity;
import com.task_manager.form.TaskRowForm;

@Component
public class TaskRowConverter {
	
	/** 
	 * {@link TaskEntity}型のオブジェクトを{@link TaskRowForm}型に詰め替える
	 * 
	 * @param entity {@link TaskEntity}型のオブジェクト
	 * @param userMap keyに{@link UserEntity}のId、valueに{@link UserEntity}のuserNameを持つ{@link Map}型のオブジェクト
	 * @return taskRowForm {@link TaskRowForm}型のオブジェクト 
	 * */
	public TaskRowForm convert(TaskEntity entity, Map<Integer, String> userMap) {
		TaskRowForm taskRowForm = new TaskRowForm();
		taskRowForm.setId(entity.getTaskId());
		taskRowForm.setTaskName(entity.getTaskName());
		taskRowForm.setTaskDscript(entity.getTaskDscript());
		taskRowForm.setDueDate(new SimpleDateFormat("yyyy/MM/dd").format(entity.getDueDate()));
		taskRowForm.setPriorityLabel(formatPriority(entity.getPriority()));
		taskRowForm.setStatusLabel(formatStatus(entity.getStatus()));
		taskRowForm.setMngUser(userMap.getOrDefault(entity.getMngUser(), "未設定"));
		taskRowForm.setCrtUser(userMap.getOrDefault(entity.getUserId(), "不明"));
		return taskRowForm;
	}
	
	/** 
	 * 優先度を数値から文字列に変換
	 *　
	 * @param priority 優先度(1:HIGH, 2:MEDIUM, 3:LOW。{@code null} の場合はUNKNOWN)
	 * @return 優先度を表す文字列("HIGH", "MEDIUM", "LOW", または"UNKNOWN")
	 * */
	private String formatPriority(Integer priority) {
		if(priority == null) {
			return "UNKNOWN";
		} else {
			return switch (priority) {
				case 1 -> "HIGH";
				case 2 -> "MEDIUM";
				case 3 -> "LOW";
				default -> "UNKNOWN";
			};
		}
	}
	
	/** 
	 * ステータスを数値から文字列に変換
	 * 
	 * @param status ステータス(1:未着手, 2:進行中, 3:完了。{@code null}　の場合はUNKNOWN)
	 * @return ステータスを表す文字列("未着手", "進行中", "完了", または"UNKNOWN")
	 * */
	private String formatStatus(Integer status) {
		if(status == null) {
			return "UNKNOWN";
		} else {
			return switch (status) {
				case 1 -> "未着手";
				case 2 -> "進行中";
				case 3 -> "完了";
				default -> "UNKNOWN";
			};
		}
	}

}

