package com.task_manager.entity;

import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Task {
	
	private Integer taskId;
	
	private Integer userId;
	
	private String taskName;
	
	private String taskDsript;
	
	private Date dueDate;
	
	private Integer priority;
	
	private Integer status;
	
	private Boolean delFlg;
	
	private Integer mngUser;
	
	private LocalDateTime rgstTime;
	
	private Integer updtUser;
	
	private LocalDateTime updtTime;
	
}	
