package com.task_manager.service;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.task_manager.dto.TaskListResultDto;
import com.task_manager.entity.TaskEntity;
import com.task_manager.entity.UserEntity;
import com.task_manager.form.TaskRowForm;
import com.task_manager.mapper.TaskMapper;
import com.task_manager.mapper.UserMapper;
import com.task_manager.util.TaskErrorType;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SearchAllTasksService {
	
	private final TaskMapper taskMapper;
	
	private final UserMapper userMapper;
	
	/** 
	 * 削除フラグのないタスクリストの取得
	 * 
	 * @return タスクリストの生成が成功した場合は{@link TaskListResultDto}クラスのタスクリスト、失敗した場合はエラーメッセージとエラータイプを返す。
	 * */
	public TaskListResultDto execute() {
		List<TaskEntity> taskEntities = this.taskMapper.findByDelFlgTasks(false);
		if (taskEntities == null || taskEntities.isEmpty()) {
			return TaskListResultDto.failedTaskListForm("表示するタスクがありません", TaskErrorType.TASK_NO_DATA);
		} else {
			//1.全ユーザーを一度だけ取得して、IDをキーにしたMapを作成
			Map<Integer, String> userMap = userMapper.findAllUsers().stream()
					.collect(Collectors.toMap(
							UserEntity::getId,
							UserEntity::getUserName
							));
			
			//2.TaskEntityからTaskRowFormへの詰め替え
			List<TaskRowForm> taskForms = taskEntities.stream().map(entity -> {
				TaskRowForm taskForm = new TaskRowForm();
				taskForm.setId(entity.getTaskId());
				taskForm.setTaskName(entity.getTaskName());
				taskForm.setTaskDscript(entity.getTaskDscript());
				
				//Date型をString型に変換
				taskForm.setDueDate(new SimpleDateFormat("yyyy/MM/dd").format(entity.getDueDate()));
				
				//優先度を数値から文字列に変換
				taskForm.setPriorityLabel(convertPriority(entity.getPriority()));
				
				//ステータスを数値から文字列に変換
				taskForm.setStatusLabel(convertStatus(entity.getStatus()));
				
				//担当者を数値(userId)から文字列(name)に変換
				taskForm.setMngUser(userMap.getOrDefault(entity.getMngUser(), "未設定"));
				
				//タスク設定者を数値（userId)から文字列(name)に変換
				taskForm.setCrtUser(userMap.getOrDefault(entity.getUserId(), "不明"));
				
				return taskForm;
				
			}).toList();
			return TaskListResultDto.succeedTaskListForm(taskForms);
		}
		
	}
	
	/** 
	 * 優先度を数値から文字列に変換
	 *　
	 * @param priority 優先度(1:HIGH, 2:MEDIUM, 3:LOW。{@code null} の場合はUNKNOWN)
	 * @return 優先度を表す文字列("HIGH", "MEDIUM", "LOW", または"UNKNOWN")
	 * */
	private String convertPriority(Integer priority) {
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
	private String convertStatus(Integer status) {
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
