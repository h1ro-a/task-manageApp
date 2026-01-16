package com.task_manager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.task_manager.mapper.UserMapper;
import com.task_manager.dto.UserOptionDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ListUserOptionsService {

	private final UserMapper userMapper;
	
	
	/** 　
	 * タスク担当者選択用のユーザー候補一覧を取得
	 * 
	 * @return 担当者選択に使用するユーザー候補の一覧
	 * */
	public List<UserOptionDto> execute() {
		return userMapper.findAllUsers().stream()
				.map(u -> new UserOptionDto(u.getId(), u.getUserName()))
				.toList();
	}
}
