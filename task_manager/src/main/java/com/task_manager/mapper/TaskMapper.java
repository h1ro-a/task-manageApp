package com.task_manager.mapper;

import java.sql.Date;
import java.time.OffsetDateTime;
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

	/** 
	 * 新規タスク登録
	 * 
	 * @param userId ログインユーザーID
	 * @param taskName タスク名
	 * @param taskDscript 説明
	 * @param dueDate 期限日
	 * @param priority 優先度
	 * @param status ステータス
	 * @param delFlg 削除フラグ
	 * @param mngUser 担当者
	 * @param rgstTime 登録日時
	 * @param updtUser 作成者
	 * @param updtTime 作成日時
	 * */
	List<TaskEntity> createTask(@Param("userId") Integer userId, @Param("taskName") String taskName,
			@Param("taskDscript") String taskDscript, @Param("dueDate") Date dueDate,
			@Param("priority") Integer priority, @Param("status") Integer status,
			@Param("delFlg") Boolean delFlg, @Param("mngUser") Integer mngUser,
			@Param("rgstTime") OffsetDateTime rgstTime, @Param("updtUser") Integer updtUser,
			@Param("updtTime") OffsetDateTime updtTime);
	


}
