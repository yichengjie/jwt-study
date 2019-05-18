package com.yicj.jwt.modules.user.service;

import com.yicj.jwt.modules.user.entity.User;

public interface UserService {
	User findUserById(String userId) ;
	User findByUsername(User user);
}
