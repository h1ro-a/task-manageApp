package com.task_manager.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.task_manager.entity.User;

@Mapper
public interface UserMapper {
	/**　
	 * ユーザー全件取得 
	 * */
	List<User> findAllUsers();
	
	/**
	 * アクティブなユーザーを全件取得 
	 * 
	 * @param delFlg
	 * @return アクティブなユーザーエンティティ
	 * */
	List<User> findByDelFlgUsers(@Param("delFlg") Boolean delFlg);
	
	/**
	 * IDを指定してユーザーを取得 
	 * 
	 * @param id
	 * @param delFlg
	 * @return 指定したidのユーザーエンティティ
	 * 
	 * */
	List<User> findByIdUser(@Param("id") Integer id, @Param("delFlg") Boolean delFlg);
	
	
	/** 
	 * ログインidとパスワードを指定して取得
	 * @param loginId
	 * @param password
	 * @param delFlg
	 * @return　ログインするユーザー
	 * */
	User findByLoginIdAndPassword(@Param("loginId") String loginId, @Param("password") String password);
	
	/**
	 * ユーザー登録 
	 * */
	User insert();
	
	/**
	 * ユーザー削除 
	 * */
	User delete();
	
	

}
