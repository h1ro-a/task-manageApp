package com.task_manager.form;


import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class LoginForm {
	/** ログインID*/
	private String loginId;
	
	/** パスワード　*/
	private String password;
	
	/** ユーザー名　*/
	private String name;
	
//	/** 
//	 * ログインIDの取得
//	 * 
//	 * @return ログインID
//	 * */
//	public String getloginId() {
//		return loginId;
//	}
//	
//	/** 
//	 * ログインIDのセット
//	 * 
//	 * @param loginId ログインID
//	 * */
//	public void setloginId(String loginId) {
//		this.loginId = loginId;
//	}
//	
//	/** 
//	 * パスワードの取得
//	 * 
//	 * @return パスワード
//	 * */
//	public String getPassword() {
//		return password;
//	}
//	
//	/** 
//	 * パスワードのセット
//	 * 
//	 * */
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}

}
