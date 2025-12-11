package com.task_manager.entity;

import lombok.Data;

@Data
public class User {
	
	private Integer userId;
	
	private String userName;
	
	private String loginId;
	
	private String password;
	
	private Boolean delFlg;

}
