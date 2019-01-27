
package com.turtlebone.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.turtlebone.base.util.BeanCopyUtils;
import com.turtlebone.main.entity.User;
import com.turtlebone.main.repository.UserRepository;
import com.turtlebone.main.model.UserModel;
import com.turtlebone.main.service.UserService;

@Service
@com.alibaba.dubbo.config.annotation.Service(interfaceClass = UserService.class)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int deleteByPrimaryKey(Integer id) {
		return userRepo.deleteByPrimaryKey(id);
	}
	

    /*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public UserModel findByPrimaryKey(Integer id) {
		User user = userRepo.selectByPrimaryKey(id);
		return BeanCopyUtils.map(user, UserModel.class);
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKey(UserModel userModel) {
		return userRepo.updateByPrimaryKey(BeanCopyUtils.map(userModel, User.class));
	}
	
	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int updateByPrimaryKeySelective(UserModel userModel) {
		return userRepo.updateByPrimaryKeySelective(BeanCopyUtils.map(userModel, User.class));
	}
	

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int create(UserModel userModel) {
		return userRepo.insert(BeanCopyUtils.map(userModel, User.class));
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int createSelective(UserModel userModel) {
		return userRepo.insertSelective(BeanCopyUtils.map(userModel, User.class));
	}

	/*
	 * @Transactional is not necessarry for the single atomic CRUD statement for better performance, 
	 * but you still have to take care of @Transactional for multi-statements scenario.
	 * if read only,please config as "@Transactional(readOnly = true)",otherwise "@Transactional"
	 */
	@Override
	public int selectCount(UserModel userModel) {
		return userRepo.selectCount(BeanCopyUtils.map(userModel, User.class));
	}


	@Override
	public UserModel queryByToken(String tokenId) {
		User user = new User();
		user.setOpenid(tokenId);
		List<User> list = userRepo.selectPage(user, PageRequest.of(0, 100, Sort.by("id")));
		if (list != null && list.size() == 1) {
			return BeanCopyUtils.map(list.get(0), UserModel.class);
		}
		return null;
	}



}
