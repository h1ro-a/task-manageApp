package com.task_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.task_manager.service.SearchAllTasksService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ListController {
	
	private final SearchAllTasksService searchAllTasksService;
	
	/** 
	 * タスクの全件表示
	 * 
	 * @return タスクリスト
	 * */
	@GetMapping("/list")
	public String findAll(Model model) {
		model.addAttribute("taskListResultDto", searchAllTasksService.execute());
		return "list/list";
	}
}
