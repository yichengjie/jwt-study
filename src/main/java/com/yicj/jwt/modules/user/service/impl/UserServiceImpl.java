package com.yicj.jwt.modules.user.service.impl;

import org.springframework.stereotype.Service;

import com.yicj.jwt.modules.user.entity.User;
import com.yicj.jwt.modules.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Override
	public User findUserById(Long userId) {
		User user = new User() ;
		user.setId(userId);
		user.setUsername("yicj");
		user.setPassword("y123456");
		return user;
	}

	@Override
	public User findByUsername(User user) {
		User u = new User() ;
		u.setId(1000l);
		u.setUsername(user.getUsername());
		u.setPassword("y123456");
		return u;
	}

}
