package com.yicj.demo.modules.user.service.impl;

import org.springframework.stereotype.Service;

import com.yicj.demo.modules.user.entity.User;
import com.yicj.demo.modules.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Override
	public User findUserById(String userId) {
		User user = new User() ;
		user.setId(userId);
		user.setUsername("yicj");
		user.setPassword("y123456");
		return user;
	}

	@Override
	public User findByUsername(User user) {
		User u = new User() ;
		u.setId("001");
		u.setUsername(user.getUsername());
		u.setPassword("y123456");
		return u;
	}

}
