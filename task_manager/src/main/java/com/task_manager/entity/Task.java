package com.task_manager.entity;

import java.sql.Date;
import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class Task {
	
	private Integer taskId;
	
	private Integer userId;
	
	private String taskName;
	
	private String taskDscript;
	
	private Date dueDate;
	
	private Integer priority;
	
	private Integer status;
	
	private Boolean delFlg;
	
	private Integer mngUser;
	
	private OffsetDateTime rgstTime;
	
	private Integer updtUser;
	
	private OffsetDateTime updtTime;
	
}	
