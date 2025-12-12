package com.task_manager.dto;

import com.task_manager.entity.User;
import com.task_manager.util.LoginErrorType;

public class LoginResultDto {
	
	private boolean isLogin;
	
	private User loginUser;
	
	private String errorMsg;
	
	private LoginErrorType loginErrorType;
	
	/** 
	 * ログイン成功時のコンストラクタ
	 * 
	 * @param loginUser ログイン成功したユーザー情報
	 * */
	private LoginResultDto(User loginUser) {
		this.loginUser = loginUser;
		this.isLogin = true;
	}
	
	/**
	 * ログイン失敗時のコンストラクタ 
	 * 
	 * @param errorMsg
	 * @param loginErrorType
	 * */
	private LoginResultDto(String errorMsg, LoginErrorType loginErrorType) {
		this.errorMsg = errorMsg;
		this.loginErrorType = loginErrorType;
		
	}
	
	/** 
	 * ログイン成功時の結果を返すファクトリメソッド
	 * 
	 * @param loginUser ログイン成功したユーザー情報
	 * @return ログイン成功を示す{@link LoginResultDto} インスタンス
	 * */
	public static LoginResultDto succeedLogin(User loginUser) {
		return new LoginResultDto(loginUser);
	}
	/** 
	 * ログイン失敗時の結果を返すファクトリメソッド
	 * 
	 * @param errorMsg
	 * @param loginErrorType
	 * @return ログイン失敗を示す{@link LoginResultDto} インスタンス
	 * */
	
	public static LoginResultDto failLogin(String errorMsg, LoginErrorType loginErrorType) {
		return new LoginResultDto(errorMsg, loginErrorType);
	}
	
	public boolean isLogin() {
		return isLogin;
	}
	
	public User getLoginUser() {
		return loginUser;
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public LoginErrorType getloLoginErrorType() {
		return loginErrorType;
	}

}
