package com.task_manager.dto;

import com.task_manager.entity.UserEntity;
import com.task_manager.util.LoginErrorType;

import lombok.Getter;
@Getter
public class LoginResultDto {
	
	private final boolean login;
	
	private final UserEntity loginUser;
	
	private final String errorMsg;
	
	private final LoginErrorType loginErrorType;
	
	/** 
	 * ログイン成功時のコンストラクタ
	 * 
	 * @param loginUser ログイン成功したユーザー情報
	 * */
	private LoginResultDto(UserEntity loginUser) {
		this.login = true;
		this.loginUser = loginUser;
		//使用しないフィールドにはnullを入力
		this.errorMsg = null;
		this.loginErrorType = null;
	}
	
	/**
	 * ログイン失敗時のコンストラクタ 
	 * 
	 * @param errorMsg
	 * @param loginErrorType
	 * */
	private LoginResultDto(String errorMsg, LoginErrorType loginErrorType) {
		this.login = false;
		this.errorMsg = errorMsg;
		this.loginErrorType = loginErrorType;
		//使用しないフィールドにはnullを入力
		this.loginUser = null;
		
	}
	
	/** 
	 * ログイン成功時の結果を返すファクトリメソッド
	 * 
	 * @param loginUser ログイン成功したユーザー情報
	 * @return ログイン成功を示す{@link LoginResultDto}インスタンス
	 * */
	public static LoginResultDto succeedLogin(UserEntity loginUser) {
		return new LoginResultDto(loginUser);
	}
	/** 
	 * ログイン失敗時の結果を返すファクトリメソッド
	 * 
	 * @param errorMsg
	 * @param loginErrorType
	 * @return ログイン失敗を示す{@link LoginResultDto}インスタンス
	 * */
	
	public static LoginResultDto failedLogin(String errorMsg, LoginErrorType loginErrorType) {
		return new LoginResultDto(errorMsg, loginErrorType);
	}

}
