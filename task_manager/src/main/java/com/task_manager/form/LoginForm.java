package com.task_manager.form;


import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Max;
//import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginForm {
	/** ログインID*/
	@NotNull
	private String loginId;
	
	/** パスワード　*/
	@NotBlank
	private String loginPass;
	
	/** 
	 * ログインIDの取得
	 * 
	 * @return ログインID
	 * */
	public String getloginId() {
		return loginId;
	}
	
	/** 
	 * ログインIDのセット
	 * 
	 * @param loginId ログインID
	 * */
	public void setloginId(String loginId) {
		this.loginId = loginId;
	}
	
	/** 
	 * パスワードの取得
	 * 
	 * @return パスワード
	 * */
	public String getPass() {
		return loginPass;
	}
	
	/** 
	 * パスワードのセット
	 * 
	 * @param loginPass パスワード
	 * */
	public void getloginPass(String loginPass) {
		this.loginPass = loginPass;
	}

}
