package com.task_manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.task_manager.service.SearchAllTasksService;

@Controller
public class ListController {
	@Autowired
	SearchAllTasksService searchAllTasksService;
	
	@RequestMapping(path = "/list", method = RequestMethod.GET)
	public String findAll(Model model) {
		model.addAttribute("users", searchAllTasksService.execute(false));
		return "list/list";
	}
	

}
