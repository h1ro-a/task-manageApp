package com.task_manager.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.task_manager.entity.TaskEntity;

@Mapper
public interface TaskMapper {
	/** 
	 * タスク全件取得
	 * @return 全てのタスクを格納したリスト
	 * 
	 * */
	List<TaskEntity> findAllTasks();
	
	/** 
	 * 削除していないタスクを全件取得
	 * 
	 * @param delFlg
	 * @return アクティブなタスクを格納したリスト
	 * */
	List<TaskEntity> findByDelFlgTasks(@Param("delFlg") Boolean delFlg);
	
	/**
	 * タスク名の完全一致・部分一致検索を行い該当するタスクを取得
	 * 
	 * @param delFlg
	 * @param taskName 検索キーワード（部分一致、あるいは完全一致）。空文字またはnullの場合は全件取得
	 * @return 条件に一致したタスクのリスト
	 * */
	List<TaskEntity> findByTaskName(@Param("delFlg") Boolean delFlg, @Param("taskName") String taskName);

	
	


}
