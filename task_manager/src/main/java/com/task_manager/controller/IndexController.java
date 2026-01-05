package com.task_manager.controller;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.task_manager.dto.LoginResultDto;
import com.task_manager.form.LoginForm;
import com.task_manager.service.LoginService;

@RequiredArgsConstructor
@Controller
public class IndexController {
	
	private final HttpSession session;
	
	private final LoginService loginService;
	
	/**
	 * ログイン画面の初期表示
	 * 
	 * @param loginForm
	 * @return 遷移先ビュー
	 */
	@GetMapping("/")
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
	 * @return 遷移先ビュー
	 * 
	 * */
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("loginForm") LoginForm loginForm,
			BindingResult result,
			Model model) {
		//　入力チェック
		if (result.hasErrors()) {
			System.out.println("チェック");
			return "index";
		}
		//　ログイン判定
		LoginResultDto loginResultDto = loginService.execute(loginForm);
		
		if (loginResultDto.isLogin()) {
			session.setAttribute("loginUser", loginResultDto.getLoginUser());
			return "redirect:/list";
		} else {
			model.addAttribute("loginResultDto", loginResultDto);
			return "index";
		}
	}
	
	
	/** 
	 * ログアウト処理
	 * 
	 * @return ログイン画面
	 * */
	@PostMapping("/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}

}
