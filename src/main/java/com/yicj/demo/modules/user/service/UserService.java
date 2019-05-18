package com.yicj.demo.modules.user.service;

import com.yicj.demo.modules.user.entity.User;

public interface UserService {
	User findUserById(String userId) ;
	User findByUsername(User user);
}
