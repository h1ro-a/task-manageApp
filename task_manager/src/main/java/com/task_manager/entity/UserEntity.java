package com.task_manager.entity;

import lombok.Data;

@Data
public class UserEntity {
	
	private Integer id;
	
	private String userName;
	
	private String loginId;
	
	private String password;
	
	private Boolean delFlg;

}
