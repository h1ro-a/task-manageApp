package com.task_manager.controller;


import ch.qos.logback.core.net.LoginAuthenticator;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.task_manager.dto.LoginResultDto;
import com.task_manager.form.LoginForm;
import com.task_manager.service.LoginService;

@Controller
public class IndexController {
	
	@Autowired
	HttpSession session;
	
	@Autowired
	LoginService loginService;
	
	/**
	 * ログイン画面の初期表示
	 * 
	 * @param loginForm
	 * @return 遷移先ビュー
	 */
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String index(@ModelAttribute LoginForm loginForm) {
		session.invalidate();
		return "index";
		
	}
	
	/** 
	 * ログイン画面『ログイン』ボタン押下
	 * 
	 * @param {@link LoginForm}
	 * @param result エラー検知オブジェクト
	 * @param session
	 * @param model リクエストスコープの操作
	 * @param 遷移先ビュー
	 * 
	 * */
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute LoginForm loginForm, BindingResult result, HttpSession session, Model model) {
		//　入力チェック
		if (result.hasErrors()) {
			System.out.println("チェック");
			return "index";
		}
		//　ログイン判定
		LoginResultDto loginResultDto = loginService.execute(loginForm);
		if (loginResultDto.isLogin()) {
			session.setAttribute("user", loginResultDto.getLoginUser());
			return "redirect:/list";
		}
		model.addAttribute("errMessage", loginResultDto.getErrorMsg());
		return "index";
	}

}
