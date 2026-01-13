package com.task_manager.form;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateTaskForm {
	
	@NotBlank
	private String taskName;
	
	private String taskDscript;
	
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dueDate;
	
	@NotNull
	private Integer priority;
	
	@NotNull
	private Integer status;
	
	@NotNull
	private Integer mngUser;
	
	
	
}
