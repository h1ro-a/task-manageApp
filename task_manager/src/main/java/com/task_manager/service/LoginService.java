package com.task_manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task_manager.dto.LoginResultDto;
import com.task_manager.entity.User;
import com.task_manager.form.LoginForm;
import com.task_manager.mapper.UserMapper;
import com.task_manager.util.LoginErrorType;

@Service
public class LoginService {
	
	@Autowired
	private UserMapper mapper;
	
	/** 
	 * ログイン処理
	 * 
	 * @param loginForm
	 * @return ログインが成功した場合は{@link LoginResultDto}クラスのインスタンス、失敗した場合はエラーメッセージとエラータイプを返す。
	 * */
	
	public LoginResultDto execute(LoginForm loginForm) {
		User loginUser = this.mapper.findByLoginIdAndPassword(loginForm.getLoginId(), loginForm.getPassword());
		if (loginUser == null) {
			return LoginResultDto.failedLogin("ログインID、またはパスワードが間違っています", LoginErrorType.USER_NOT_FOUND);
		} else { 
			System.out.println(loginUser.getLoginId());
			System.out.println(loginUser.getPassword());
			return LoginResultDto.succeedLogin(loginUser);
		}
	}
	
}
