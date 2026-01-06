package com.task_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.task_manager.dto.TaskListResultDto;
import com.task_manager.form.SearchTaskNameForm;
import com.task_manager.service.SearchTaskService;
import com.task_manager.service.ViewAllTasksService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class ListController {

	
	private final ViewAllTasksService viewAllTasksService;
	
	private final SearchTaskService searchTaskService;
	
	/** 
	 * タスクの全件表示
	 * 
	 * @param model モデル
	 * @return タスクリスト
	 * */
	@GetMapping("/list")
	public String findAll(@ModelAttribute("searchTaskNameForm") SearchTaskNameForm searchTaskNameForm,
			Model model) {
		model.addAttribute("taskListResultDto", viewAllTasksService.execute());
		return "list/list";
	}
	
	/** 
	 * タスク名を検索した結果を出力
	 * 
	 * @param model モデル
	 * @return タスクリスト
	 * */
	@GetMapping("/list/taskName")
	public String findByTaskName(
			@Valid @ModelAttribute("searchTaskNameForm") SearchTaskNameForm searchTaskNameForm,
			Model model) {
		TaskListResultDto taskListResultDto = searchTaskService.execute(searchTaskNameForm);
		model.addAttribute("taskListResultDto", taskListResultDto);
		return "list/list";
		
	}
}
