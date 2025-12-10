package com.task_manager.controller;

import ch.qos.logback.core.net.LoginAuthenticator;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.task_manager.form.LoginForm;

@Controller
public class IndexController {
	
	@Autowired
	HttpSession session;
	
	/**
	 * ログイン画面の表示
	 * 
	 * @param loginForm
	 * @return 遷移先ビュー
	 */
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(@ModelAttribute LoginForm loginForm) {
		session.invalidate();
		return "index";
		
	}
	
	

}
