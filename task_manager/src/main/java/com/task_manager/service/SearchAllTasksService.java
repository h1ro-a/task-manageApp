package com.task_manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task_manager.entity.Task;
import com.task_manager.mapper.TaskMapper;

@Service
public class SearchAllTasksService {
	
	@Autowired
	private TaskMapper mapper;
	
	/** 
	 * 削除フラグのないタスク全件取得
	 * @param delFlg
	 * @return タスクエンティティ
	 * */
	public List<Task> execute(Boolean delFlg) {
		return mapper.findByDelFlgTasks(delFlg);
	}

}
