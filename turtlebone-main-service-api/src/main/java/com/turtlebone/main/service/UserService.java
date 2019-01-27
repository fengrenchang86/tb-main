
package com.turtlebone.main.service;

import com.turtlebone.main.model.UserModel;

public interface UserService{
	
	public int create(UserModel userModel);
	
	public int createSelective(UserModel userModel);
	
	public UserModel findByPrimaryKey(Integer id);
	
	public int updateByPrimaryKey(UserModel userModel);
	
	public int updateByPrimaryKeySelective(UserModel userModel);
	
	public int deleteByPrimaryKey(Integer id);
	

	public int selectCount(UserModel userModel);
	
	public UserModel queryByToken(String tokenId);
	
}