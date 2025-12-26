package com.task_manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.task_manager.entity.TaskEntity;

@Mapper
public interface TaskMapper {
	/** 
	 * タスク全件取得
	 * @return 全てのタスクエンティティ
	 * 
	 * */
	List<TaskEntity> findAllTasks();
	
	/** 
	 * 削除していないタスクを全件取得
	 * 
	 * @param delFlg
	 * @return アクティブなタスクエンティティ
	 * */
	List<TaskEntity> findByDelFlgTasks(@Param("delFlg") Boolean delFlg);
	
	


}
